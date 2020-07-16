package com.example.owl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;

public class Pesquisar extends AppCompatActivity   implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);
        ImageButton img = findViewById(R.id.iconBack);
        img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Button btnFiltrar = findViewById(R.id.btnfiltrar);
        btnFiltrar.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnfiltrar) {
            //indicar qual tela que será aberta
            Intent it = new Intent(
                    getApplicationContext(),  //tela atual
                    Pesquisar2.class     //proximatela
            );


            CheckBox chk1 = findViewById(R.id.clivros);//descobrir se foi clicado
            CheckBox chk2 = findViewById(R.id.cautor);
            CheckBox chk3 = findViewById(R.id.ceditora);
            CheckBox chk4 = findViewById(R.id.cpessoas);
            String pesquisar = " ";
            if (chk1.isChecked()) {//quando clicado o que deve fazer
                pesquisar += "Livros \n";
            }
            if (chk2.isChecked()) {
                pesquisar += "Autor \n";
            }
            if (chk3.isChecked()) {
                pesquisar += "Editora \n";
            }
            if (chk4.isChecked()) {
                pesquisar += "Pessoas \n";
            }

            it.putExtra("filtro", pesquisar);

            //Retornar as Observações
            EditText edt1 = findViewById(R.id.edtoutros);
            it.putExtra("outrosfiltros", edt1.getText().toString());

            startActivity(it);

        }


    }

}