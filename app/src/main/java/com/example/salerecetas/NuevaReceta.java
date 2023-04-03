package com.example.salerecetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevaReceta extends AppCompatActivity{
    EditText et_Duracion,
            et_TituloReceta,
            et_Ingredientes,
            et_ModoPreparacion,
            et_imagenURL;
    Button bt_guardar, bt_volver;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_receta);

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

        bt_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                DDBBReceta ddbbReceta = new DDBBReceta(NuevaReceta.this);
                String nombreTXT = et_TituloReceta.getText().toString();
                String duracionTXT = et_Duracion.getText().toString();
                String ingredientesTXT = et_Ingredientes.getText().toString();
                String descrpcionTXT = et_ModoPreparacion.getText().toString();
                String imagenURLTXT = et_imagenURL.getText().toString();

                long check = ddbbReceta.insertarReceta(nombreTXT, duracionTXT, ingredientesTXT, descrpcionTXT, imagenURLTXT);
                if (check > 0){
                    Toast.makeText(NuevaReceta.this, "Receta guardada", Toast.LENGTH_SHORT).show();
                    et_TituloReceta.setText("");
                    et_Duracion.setText("");
                    et_Ingredientes.setText("");
                    et_ModoPreparacion.setText("");
                    et_imagenURL.setText("");
                }else Toast.makeText(NuevaReceta.this, "Faltan campos por rellenar", Toast.LENGTH_SHORT).show();
            }

        });
        bt_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                startActivity(new Intent(NuevaReceta.this,MostrarListaRecetas.class ));
            }
            });
    }
 }