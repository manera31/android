package com.joanmanera.tabs.modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {
    private String razonSocial;
    private int cif;
    private String direccion;
    private String web;
    private String correoElectronico;

    public Empresa(String razonSocial, int cif, String direccion, String web, String correoElectronico) {
        this.razonSocial = razonSocial;
        this.cif = cif;
        this.direccion = direccion;
        this.web = web;
        this.correoElectronico = correoElectronico;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public int getCif() {
        return cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getWeb() {
        return web;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
}
