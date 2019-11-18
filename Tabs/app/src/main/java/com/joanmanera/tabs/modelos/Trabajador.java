package com.joanmanera.tabs.modelos;

import java.io.Serializable;

public class Trabajador implements Serializable {
    private String nombre;
    private String apellidos;
    private String nif;
    private String fechaNacimiento;
    private String direccion;
    private Usuario usuario;
    private Empresa empresa;

    public Trabajador(String nombre, String apellidos, String nif, String fechaNacimiento, String direccion, Usuario usuario, Empresa empresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.usuario = usuario;
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNif() {
        return nif;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }
}
