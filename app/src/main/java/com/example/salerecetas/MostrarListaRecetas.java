package com.example.salerecetas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MostrarListaRecetas extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Receta> recetaArrayList;
    Button bt_anadirReceta, bt_mas;
    MyRecetaRecyclerViewAdapter myRecetaRecyclerViewAdapter;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista_recetas);

        // Color de la barra y logo
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.chocolate)));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // Sonido boton
        mediaPlayer = MediaPlayer.create(this, R.raw.sonido_boton);

        recyclerView = findViewById(R.id.listaRecetasRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(MostrarListaRecetas.this));
        DDBBReceta ddbbReceta = new DDBBReceta(MostrarListaRecetas.this);
        recetaArrayList = new ArrayList<>();

        myRecetaRecyclerViewAdapter = new MyRecetaRecyclerViewAdapter(ddbbReceta.mostrarRecetas());
        recyclerView.setAdapter(myRecetaRecyclerViewAdapter);


        bt_anadirReceta = findViewById(R.id.buttonAnadirReceta);
        bt_anadirReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                startActivity(new Intent(MostrarListaRecetas.this,NuevaReceta.class ));
            }
        });
        bt_mas  = findViewById(R.id.buttonMas);
        bt_mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                startActivity(new Intent(MostrarListaRecetas.this,MasOpciones.class ));
            }
        });
    }
}