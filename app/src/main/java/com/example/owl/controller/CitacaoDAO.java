package com.example.owl.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class CitacaoDAO {
    private final DataBaseHelper dh;

    public CitacaoDAO(DataBaseHelper dh) {
        this.dh = dh;
    }

    public long inserir(ContentValues obj) {
        SQLiteDatabase db = dh.getWritableDatabase();
        long id = db.insert(
                "tb_citacoes",
                null,
                obj);
        return id;
    }
}
