package com.joanmanera.listadelacomprafirebase.Models;

public class ProductoLista {
    private String nombreLista;
    private String nombreProducto;
    private boolean estaComprada;

    public ProductoLista(String nombreLista, String nombreProducto, boolean estaComprada) {
        this.nombreLista = nombreLista;
        this.nombreProducto = nombreProducto;
        this.estaComprada = estaComprada;
    }

    public ProductoLista() {
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public boolean isEstaComprada() {
        return estaComprada;
    }

    public void setEstaComprada(boolean estaComprada) {
        this.estaComprada = estaComprada;
    }
}
