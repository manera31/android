package com.joanmanera.listacontactos;

import android.content.Context;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ContactParser {
    private Contacto[] contactos;
    private InputStream archivoContactos;

    public ContactParser(Context c){
        this.archivoContactos = c.getResources().openRawResource(R.raw.contacts);
    }

    public boolean parse() throws IOException {
        boolean parsed = false;
        ArrayList<Contacto> contactosArrayList = new ArrayList<>();
        JsonReader reader = new JsonReader(new InputStreamReader(archivoContactos, "UTF-8"));

        try {
            reader.beginArray();
            while (reader.hasNext()){
                contactosArrayList.add(leerContacto(reader));
            }
            reader.endArray();

            contactos = new Contacto[contactosArrayList.size()];
            for (int i = 0 ; i < contactos.length ; i++){
                contactos[i] = contactosArrayList.get(i);
            }

            parsed = true;

        } catch (IOException ioe){

        } finally {
            reader.close();
        }

        return parsed;
    }

    private Contacto leerContacto (JsonReader reader) throws IOException {
        String nombre = null;
        String apellido1 = null;
        String apellido2 = null;
        String direccion = null;
        String empresa = null;
        String fechaNacimiento = null;
        String telefono1 = null;
        String telefono2 = null;
        String email = null;

        reader.beginObject();
        while (reader.hasNext()){
            String aux = reader.nextName();
            switch (aux){
                case "name":
                    nombre = reader.nextString();
                    break;
                case "firstSurname":
                    apellido1 = reader.nextString();
                    break;
                case "secondSurname":
                    apellido2 = reader.nextString();
                    break;
                case "birth":
                    fechaNacimiento = reader.nextString();
                    break;
                case "company":
                    empresa = reader.nextString();
                    break;
                case "email":
                    email = reader.nextString();
                    break;
                case "phone1":
                    telefono1 = reader.nextString();
                    break;
                case "phone2":
                    telefono2 = reader.nextString();
                    break;
                case "address":
                    direccion = reader.nextString();
                    break;
            }
        }
        reader.endObject();
        String apellidos = apellido1+apellido2;
        return new Contacto(nombre, apellidos, direccion, empresa, telefono1, telefono2, email, fechaNacimiento);
    }

    public Contacto[] getContactos() {
        return contactos;
    }
}
