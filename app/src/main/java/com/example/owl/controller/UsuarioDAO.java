package com.example.owl.controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsuarioDAO {

    private final DataBaseHelper dh;

    public UsuarioDAO(DataBaseHelper dh) {
        this.dh = dh;
    }

    public boolean login(ContentValues obj){
        String SQL = "SELECT * FROM tb_usuario WHERE email=? AND senha=?";
        String where[] = new String[]{
                obj.getAsString("email"),
                md5(obj.getAsString("senha"))
        };;

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor c = db.rawQuery(SQL,where);
        return c.moveToFirst();
    }


    //
    // MD5
    // Criptografar uma String para MD5
    //
    private String md5(String pass) {
        String password = null;
        MessageDigest mdEnc;
        try {
            mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(pass.getBytes(), 0, pass.length());
            pass = new BigInteger(1, mdEnc.digest()).toString(16);
            while (pass.length() < 32) {
                pass = "0" + pass;
            }
            password = pass;
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        return password;
    }

    public long inserir(ContentValues obj){

        obj.put("senha", md5(obj.getAsString("senha")));

        SQLiteDatabase db = dh.getWritableDatabase();
        long id = db.insert(
                "tb_usuario",
                null,
                obj);
        return id;
    }
}
