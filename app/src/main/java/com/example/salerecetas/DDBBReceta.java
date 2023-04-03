package com.example.salerecetas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DDBBReceta extends AdminSQLiteOpenHelper{
    Context context;
    public DDBBReceta(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarReceta(String nombre, String duracion, String ingredientes, String descripccion, String imageURL) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("duracion", duracion);
        contentValues.put("ingredientes", ingredientes);
        contentValues.put("modoPreparacion", descripccion);
        contentValues.put("imagenURL", imageURL);
        long resultado = db.insert(TABLE_RECETAS, null, contentValues);
        return resultado;
    }
    // para traer la info de la base de datos
    public ArrayList<Receta> mostrarRecetas(){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ArrayList<Receta> recetaArrayList = new ArrayList<>();
        Receta receta = null;
        Cursor cursor = null;

        // consulta a la tabla de recetas y devuelve el tipo Cursor
        cursor = database.rawQuery("SELECT nombre, duracion, imagenURL FROM "+ TABLE_RECETAS, null);
        // Pasamos el cursor al primer elemento
        if (cursor.moveToFirst()){
            do{
                receta = new Receta();
                receta.setNombre(cursor.getString(0));
                receta.setDuracion(cursor.getString(1));
                receta.setUrlFoto(cursor.getString(2));
                recetaArrayList.add(receta);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return recetaArrayList;
    }

    public Receta verReceta(int idVer){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Receta receta = null;
        Cursor cursor = null;

        // consulta a la tabla de recetas y devuelve el tipo Cursor
        cursor = database.rawQuery("SELECT * FROM "+ TABLE_RECETAS + " WHERE id = " + idVer , null);
        // Pasamos el cursor al primer elemento
        if (cursor.moveToFirst()){
            receta = new Receta();
            receta.setNombre(cursor.getString(0));
            receta.setDuracion(cursor.getString(1));
            receta.setIngredientes(cursor.getString(2));
            receta.setModoPreparacion(cursor.getString(3));
            receta.setUrlFoto(cursor.getString(4));
        }
        cursor.close();
        return receta;
    }

    public int eliminarReceta(String idVer){
        int cantidad = -1;
        SQLiteDatabase database = this.getWritableDatabase();

       try{
           cantidad = database.delete(TABLE_RECETAS, "id=" + idVer , null);
        }catch (Exception exception){
           exception.toString();
       }finally {
           database.close();
       }
        return cantidad;
    }

}
