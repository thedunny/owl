package com.example.owl.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class LivroDAO {


    private final DataBaseHelper dh;

    public LivroDAO(DataBaseHelper dh) {
            this.dh = dh;
    }

    public long inserir(ContentValues obj) {
        SQLiteDatabase db = dh.getWritableDatabase();
        long id = db.insert(
                "tb_livro",
                null,
                obj);
        return id;
    }
    public List<Object> listar(){
        String SQL = "SELECT titulo, autor, editora FROM tb_livro as p  ORDER BY p.id";
        String where[] = null;

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor c = db.rawQuery(SQL,where);

        List<Object> res = new ArrayList<Object>();
        if (c.moveToFirst()){
            do{
                ContentValues obj = new ContentValues();
                obj.put("id",c.getInt(0));
                obj.put("titulo",c.getString(1));
                obj.put("autor",c.getString(2));
                obj.put("editora",c.getString(3));
                res.add(obj);
            }while(c.moveToNext());
        }
        return res;
    }
}
