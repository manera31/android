package com.joanmanera.alumnosfragment;

import java.io.Serializable;

public class Asignatura implements Serializable {
    private String codigoAsignatura;
    private String nombreAsignatura;

    public Asignatura(String codigoAsignatura, String nombreAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }
}
