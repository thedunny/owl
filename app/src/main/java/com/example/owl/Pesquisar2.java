package com.example.owl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class Pesquisar2 extends AppCompatActivity {

        private static  final String [] PESQUISAR = new String[]{
                "Orgulho e Preconceito", "A Menina que Roubava Livros", "O Morro dos Ventos Uivantes"
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar2);

        AutoCompleteTextView edittext = findViewById(R.id.Pesquisar);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PESQUISAR);
        edittext.setAdapter(adapter);

        Intent it = getIntent();
        if(it!=null){
            EditText edt1 = findViewById(R.id.edtfiltro);
            String pedido =it.getStringExtra("filtro");
            pedido+=it.getStringExtra("outrosfiltros");
            edt1.setText(pedido);

        }
    }
}
