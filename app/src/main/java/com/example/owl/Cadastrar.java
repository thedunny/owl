package com.example.owl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.TaskStackBuilder;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.owl.controller.DataBaseHelper;
import com.example.owl.controller.UsuarioDAO;

import java.net.URISyntaxException;

public class Cadastrar extends AppCompatActivity {

    private static DataBaseHelper id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        ImageButton img = findViewById(R.id.iconBack);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

        public void enableBtn (View view){
            CheckBox chk1 = findViewById(R.id.checkconf);
            Button btnEntrar = findViewById(R.id.btnentrar);
            if (chk1.isChecked()) {//quando clicado o que deve fazer
                btnEntrar.setEnabled(true);
            }

    }


        private void criarNotificacao (String titulo, String texto){

            // 01. Definir as propriedades da Notificação
            final int NOTIFICATION_ID = 123;
            final String CHANNEL_ID = "Notificação";

            // 02. Instanciar o gerenciador de notificações
            NotificationManager notificationManager = (NotificationManager) this.getSystemService(android.content.Context.NOTIFICATION_SERVICE);


            // 03. Definir um Canal de Notificação para API >= 28
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel canal = new NotificationChannel(CHANNEL_ID, "canal", importance);
                canal.setDescription("Canal de Notificação");
                canal.enableLights(true);
                canal.setLightColor(android.graphics.Color.RED);
                canal.enableVibration(true);
                canal.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                canal.setShowBadge(true);
                notificationManager.createNotificationChannel(canal);
            }

            // 04. Especificar o ícone, o título e a mensagem da notificação
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(titulo)
                    .setContentText(texto);

            // 05. Definir qual Atividade será chamada quando o usuário clicar na notificação
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(MainActivity.class);
            stackBuilder.addNextIntent(new Intent(this, MainActivity.class));
            android.app.PendingIntent it = stackBuilder.getPendingIntent(0, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(it);

            // 06. Exibir a notificação
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }

    public void clickBotaoCadastrar(View view) {
        EditText edt1 = findViewById(R.id.edtemail);
        EditText edt2 = findViewById(R.id.txtBoxsenha);
        EditText edt3 = findViewById(R.id.txtBoxconsenha);
        if (edt2.getText().toString().equals(edt3.getText().toString())){
            ContentValues obj = new ContentValues();
            obj.put("email",edt1.getText().toString());
            obj.put("senha", edt2.getText().toString());
            id = new DataBaseHelper(getApplicationContext());
            long idd =  new UsuarioDAO(id).inserir(obj);

            if (idd > 0) {

                final AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle(getTitle());
                dlg.setCancelable(false);
                dlg.setMessage("O usuário foi cadastrado com sucesso");
                dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent it = new Intent(
                                getApplicationContext(),
                                MainActivity.class
                        );
                        criarNotificacao(
                                "Sua conta foi criada com sucesso!",
                                "Enviamos um e-mail para validar sua conta, por favor cheque sua caixa de entrada."
                        );

                        Toast.makeText(getApplicationContext(),
                                "Eae men, bora le? ",
                                Toast.LENGTH_LONG).show();

                        startActivity(it);

                    }
                });
                dlg.show();
            }else{
                Toast.makeText(getApplicationContext(),
                        "Ocorreu um erro ao inserir.",
                        Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),
                    "As senhas não são compatíveis.",
                    Toast.LENGTH_LONG).show();
        }

    }

}