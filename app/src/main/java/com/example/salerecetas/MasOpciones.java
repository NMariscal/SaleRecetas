package com.example.salerecetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MasOpciones extends AppCompatActivity {
    Button bt_eliminar, bt_volver;
    ImageButton bt_home;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_opciones);

        // Color de la barra y logo
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.chocolate)));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        mediaPlayer = MediaPlayer.create(this, R.raw.sonido_boton);

        bt_eliminar = findViewById(R.id.buttonMasEliminar);
        bt_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                startActivity(new Intent(MasOpciones.this,Eliminar.class ));
            }
        });
        bt_volver = findViewById(R.id.buttonMasVolver);
        bt_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                startActivity(new Intent(MasOpciones.this,MostrarListaRecetas.class ));
            }
        });
        bt_home = findViewById(R.id.imageButtonHomeMas);
        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                startActivity(new Intent(MasOpciones.this,MainActivity.class ));
            }
        });
    }
}