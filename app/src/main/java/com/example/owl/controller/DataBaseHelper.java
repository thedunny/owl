package com.example.owl.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "owl.db";
    private static final int DATABASE_VERSION = 5;


    private static final String CREATE_TABLE_USUARIO =
            "CREATE TABLE tb_usuario (" +
                    "email TEXT PRIMARY KEY, " +
                    "senha TEXT " +
                    ")";

    private static final String CREATE_TABLE_LIVRO =
            "CREATE TABLE tb_livro (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "titulo TEXT, " +
                    "autor TEXT," +
                    "editora TEXT " +
                    ")";

    private static final String CREATE_TABLE_CITACOES =
            "CREATE TABLE tb_citacoes (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "titulo TEXT, " +
                    "citacao TEXT" +
                     ")";
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USUARIO);
        db.execSQL("INSERT INTO tb_usuario (email,senha) values ('dani','e10adc3949ba59abbe56e057f20f883e')");
        db.execSQL(CREATE_TABLE_LIVRO);
        db.execSQL(CREATE_TABLE_CITACOES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE tb_usuario");
        db.execSQL("DROP TABLE tb_livro");
        db.execSQL("DROP TABLE tb_citacao");
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}