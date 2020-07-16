package com.example.owl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class EsqueciSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha);
        ImageButton img = findViewById(R.id.imgback);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
    public void clickbtn (View view){
        Toast.makeText(getApplicationContext(),
                "Um e-mail foi enviado para você, cheque sua caixa de entrada.",
                Toast.LENGTH_LONG).show();

    }
}
