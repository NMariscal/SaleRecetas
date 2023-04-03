package com.example.salerecetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Ver extends AppCompatActivity {
    EditText et_Duracion,
            et_TituloReceta,
            et_Ingredientes,
            et_ModoPreparacion,
            et_imagenURL;
    Button bt_guardar, bt_volver;
    ImageButton bt_home;
    Receta receta;
    int idReceta = 0;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        // Color de la barra y logo
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.chocolate)));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        mediaPlayer = MediaPlayer.create(this, R.raw.sonido_boton);

        et_TituloReceta = (EditText) findViewById(R.id.editTextTituloRecetaVer);
        et_Duracion = (EditText) findViewById(R.id.editTextDuracionVer);
        et_Ingredientes = (EditText) findViewById(R.id.editTextMultiLineIngredientesVer);
        et_ModoPreparacion = (EditText) findViewById(R.id.editTextMultiLineModoPreparacionVer);
        et_imagenURL = (EditText) findViewById(R.id.editTextURLVer);
        bt_guardar = findViewById(R.id.buttonGuardarVer);
        bt_volver = findViewById(R.id.buttonVolver);

        bt_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                startActivity(new Intent(Ver.this, MostrarListaRecetas.class ));
            }
        });

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                idReceta = Integer.parseInt(null);
            }else{
                idReceta = extras.getInt("ID");
            }
        }else{
            idReceta = (int) savedInstanceState.getSerializable("ID");
        }

        DDBBReceta ddbbReceta = new DDBBReceta(Ver.this);
        receta = ddbbReceta.verReceta(idReceta);

        if (receta != null){
            et_TituloReceta.setText(receta.getNombre());
            et_Duracion.setText(receta.getDuracion());
            et_Ingredientes.setText(receta.getIngredientes());
            et_ModoPreparacion.setText(receta.getModoPreparacion());
            et_imagenURL.setText(receta.getUrlFoto());
            bt_guardar.setVisibility(View.INVISIBLE);
        }
    }
}