package com.joanmanera.alumnosfragment;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.Dictionary;
import java.util.HashMap;

public class AlumnosParser {

    private Alumno[] alumnos;
    private Asignatura[] asignaturas;
    private HashMap<String, Double> notas;
    private InputStream ficheroAlumnos;
    private InputStream ficheroAsignaturas;

    public AlumnosParser(Context context) {
        this.ficheroAlumnos = context.getResources().openRawResource(R.raw.alumnos_notas);
        this.ficheroAsignaturas = context.getResources().openRawResource(R.raw.asignaturas);
    }
    public boolean parse(){
        String json1 = null;
        String json2 = null;
        alumnos = null;

        try {
            //fichero alumnos
            int size = ficheroAlumnos.available();
            byte[] buffer = new byte[size];
            ficheroAlumnos.read(buffer);
            ficheroAlumnos.close();

            json1  = new String(buffer, "UTF-8");
            JSONTokener tokener = new JSONTokener(json1);
            JSONArray jsonArray = new JSONArray(tokener);

            alumnos = new Alumno[jsonArray.length()];


            for (int i = 0 ; i < alumnos.length ; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String nombre = jsonObject.getString("nombre");
                String apellido1 = jsonObject.getString("apellido1");
                String apellido2 = jsonObject.getString("apellido2");
                String fechaNacimento = jsonObject.getString("fechaNacimiento");
                String email = jsonObject.getString("email");

                JSONArray arrayNotas = jsonObject.getJSONArray("notas");
                notas = null;

                for (int x = 0 ; x < arrayNotas.length() ; x++){
                    JSONObject jsonObject2 = arrayNotas.getJSONObject(x);
                    Double nota = jsonObject2.getDouble("calificacion");
                    String codAsignatura = jsonObject2.getString("codAsig");
                    notas.put(codAsignatura, nota);
                }
                alumnos[i] = new Alumno(nombre, apellido1, apellido2, fechaNacimento, email, notas);
            }

            //fichero ficheroAsignaturas
            int size2 = ficheroAsignaturas.available();
            byte[] buffer2 = new byte[size2];
            ficheroAsignaturas.read(buffer2);
            ficheroAsignaturas.close();

            json2 = new String(buffer2, "UTF-8");
            JSONTokener tokenerAsignaturas = new JSONTokener(json2);
            JSONArray jsonArrayAsignaturas = new JSONArray(tokenerAsignaturas);

            for (int i = 0 ; i < jsonArrayAsignaturas.length() ; i++){
                JSONObject jsonObject = jsonArrayAsignaturas.getJSONObject(i);
                String codAsignatura = jsonObject.getString("codAsig");
                String nomAsignatura = jsonObject.getString("nomAsig");
                asignaturas[i] = new Asignatura(codAsignatura, nomAsignatura);
            }

        } catch (Exception e){
            return false;
        }
        return true;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public Asignatura[] getAsignaturas(){
        return asignaturas;
    }
}
