package com.example.salerecetas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    ManualInstruccionesFragment manualInstruccionesFragment;
    PantallaInicioFragment pantallaInicioFragment;
    Button comenzar;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Color de la barra y logo
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.chocolate)));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        manualInstruccionesFragment = new ManualInstruccionesFragment();
        pantallaInicioFragment = new PantallaInicioFragment();

        comenzar = (Button) findViewById(R.id.buttonAnadirReceta);
        // Añadir sonido a los botones
        mediaPlayer = MediaPlayer.create(this, R.raw.sonido_boton);
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments, pantallaInicioFragment).commit();
    }

    public void onClick(View view){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.buttonManual:
                mediaPlayer.start();
                fragmentTransaction.replace(R.id.contenedorFragments, manualInstruccionesFragment);
                break;
            case R.id.imageButtonHome:
                mediaPlayer.start();
                fragmentTransaction.replace(R.id.contenedorFragments, pantallaInicioFragment);
                break;
            case R.id.buttonComenzar1:
                mediaPlayer.start();
                Intent lista = new Intent(this, MostrarListaRecetas.class);
                startActivity(lista);
                break;
            case R.id.buttonCerrarManual:
                mediaPlayer.start();
                fragmentTransaction.replace(R.id.contenedorFragments, pantallaInicioFragment );
                break;
            case R.id.buttonAnadirReceta:
                 mediaPlayer.start();
                 Intent start = new Intent(this, NuevaReceta.class);
                 startActivity(start);
                break;
        }
        fragmentTransaction.commit();

    }


}