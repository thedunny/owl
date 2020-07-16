package com.example.owl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.owl.controller.DataBaseHelper;
import com.example.owl.controller.UsuarioDAO;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView btnCadastrar = findViewById(R.id.textView);
        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent it = new Intent(getApplicationContext(),Cadastrar.class);
                startActivity(it);
            }
        });

        Button btnEntrar = findViewById(R.id.btnentrar);
        btnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                EditText edt1 = findViewById(R.id.txtBoxemail);
                EditText edt2 = findViewById(R.id.txtBoxsenha);

                ContentValues obj = new ContentValues();
                obj.put("email", edt1.getText().toString() );
                obj.put("senha", edt2.getText().toString() );

                DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
                boolean resultado = new UsuarioDAO(dh).login(obj);

                if (resultado == true) {
                    Intent it = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(it);
                }else{
                    Toast.makeText(getApplicationContext(),"Usuário ou senha inválida", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void esqueci(View View){
        TextView txt = findViewById(R.id.txtEsqueceu);
        txt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent it = new Intent(getApplicationContext(),EsqueciSenha.class);
                startActivity(it);
            }
        });
    }
}

