package com.iesvirgendelcarmen.dam.recuperacion05;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NotificationManager notificador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton=(Button)findViewById(R.id.button1);

        notificador=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification(1,android.R.drawable.stat_sys_warning,"NOTIFICACION","PULSA LA NOTIFICACION");
            }
        });
    }

    public void notification(int id,int iconId,String titulo, String contenido){
        NotificationCompat.Builder builder=(NotificationCompat.Builder)new NotificationCompat.Builder(this)
                .setSmallIcon(iconId).setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentTitle(titulo).setContentText(contenido).setColor(getResources().getColor(R.color.colorAccent));

        Intent intent=new Intent(this,Toast01.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent= android.app.PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        notificador.notify(id,builder.build());
    }
}
