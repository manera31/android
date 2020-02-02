package com.joanmanera.listadelacomprafirebase.Models;

public class CategoriaProducto {
    private String nombreCategoria;
    private String nombreProducto;

    public CategoriaProducto(String nombreCategoria, String nombreProducto) {
        this.nombreCategoria = nombreCategoria;
        this.nombreProducto = nombreProducto;
    }

    public CategoriaProducto() {
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
