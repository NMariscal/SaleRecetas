package com.example.salerecetas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Eliminar extends AppCompatActivity {
    EditText et_id;
    Button bt_eliminar;
    ImageButton bt_home;
    boolean eliminado = false;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        // Color de la barra y logo
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.chocolate)));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // Sonido boton
        mediaPlayer = MediaPlayer.create(this, R.raw.sonido_boton);


        DDBBReceta ddbbReceta = new DDBBReceta(Eliminar.this);
        et_id = findViewById(R.id.editTextEliminar);
        bt_home = findViewById(R.id.imageButtonHomeEliminar);
        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                startActivity(new Intent(Eliminar.this,MainActivity.class ));
            }
        });

        bt_eliminar = findViewById(R.id.buttonEliminar);
        bt_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                if (ddbbReceta.eliminarReceta(et_id.getText().toString()) == 1){
                    Toast.makeText(Eliminar.this, "Eliminada correctamente", Toast.LENGTH_SHORT).show();
                    Volver();
                }else{
                    Toast.makeText(Eliminar.this, "Eliminada incorrectamente", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    public void Volver(){
        Intent intent = new Intent(this, MostrarListaRecetas.class);
        startActivity(intent);
    }
}