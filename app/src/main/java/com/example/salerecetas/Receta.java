package com.example.salerecetas;

import com.bumptech.glide.Glide;

public class Receta {
    int id;
    String nombre;
    String urlFoto;
    String duracion; // minutos
    String ingredientes;
    String modoPreparacion;


    public Receta() {
    }

    public Receta(String nombre, String duracion, String urlFoto) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.duracion = duracion;
    }

    public Receta(String nombre, String urlFoto, String duracion, String ingredientes, String modoPreparacion) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.duracion = duracion;
        this.ingredientes = ingredientes;
        this.modoPreparacion = modoPreparacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {

        this.urlFoto = urlFoto;

    }

    public Receta(int id, String nombre, String urlFoto, String duracion, String ingredientes, String modoPreparacion) {
        this.id = id;
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.duracion = duracion;
        this.ingredientes = ingredientes;
        this.modoPreparacion = modoPreparacion;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getModoPreparacion() {
        return modoPreparacion;
    }

    public void setModoPreparacion(String modoPreparacion) {
        this.modoPreparacion = modoPreparacion;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
