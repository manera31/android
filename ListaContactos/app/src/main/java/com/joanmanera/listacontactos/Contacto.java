package com.joanmanera.listacontactos;

import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String apellidos;
    private String direccion;
    private String empresa;
    private String telefono1;
    private String telefono2;
    private String email;
    private String fechaNacimiento;

    public Contacto(String nombre, String apellidos, String direccion, String empresa, String telefono1, String telefono2, String email, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.empresa = empresa;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public String getEmail() {
        return email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
}
