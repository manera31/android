package com.joanmanera.alumnosfragment;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Alumno implements Serializable {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private String email;
    private HashMap<String, Double> notas;

    public Alumno(String nombre, String apellido1, String apellido2, String fechaNacimiento, String email, HashMap<String, Double> notas) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = calcularEdad(fechaNacimiento);
        this.email = email;
        this.notas = notas;
    }

    private int calcularEdad(String fechaNacimiento){
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(fechaNacimiento);
            Calendar cal = new GregorianCalendar();
            cal.setTime(date);
        }catch (ParseException pe){
            //Error al hacer el parse
        }

        return 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public HashMap<String, Double> getNotas() {
        return notas;
    }
}
