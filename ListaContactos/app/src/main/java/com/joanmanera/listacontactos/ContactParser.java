package com.joanmanera.listacontactos;

import android.content.Context;
import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ContactParser {
    private Contacto[] contactos;
    private InputStream archivoContactos;

    public ContactParser(Context c){
        this.archivoContactos = c.getResources().openRawResource(R.raw.contacts);
    }



    public boolean parse() {
        boolean parsed = false;


        try {
            byte[] aux = new byte[archivoContactos.available()];
            archivoContactos.read(aux);
            archivoContactos.close();

            String json = new String(aux, "UTF-8");
            JSONTokener tokener = new JSONTokener(json);

            JSONArray jsonArray = new JSONArray(tokener);

            contactos = new Contacto[jsonArray.length()];
            for (int i = 0 ; i < jsonArray.length() ; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String nombre = jsonObject.getString("name");
                String apellido1 = jsonObject.getString("firstSurname");
                String apellido2 = jsonObject.getString("secondSurname");
                String foto = jsonObject.getString("photo");
                String fechaNacimeinto = jsonObject.getString("birth");
                String empresa = jsonObject.getString("company");
                String email = jsonObject.getString("email");
                String telefono1 = jsonObject.getString("phone1");
                String telefono2 = jsonObject.getString("phone2");
                String direccion = jsonObject.getString("address");

                String apellidos = apellido1+apellido2;

                contactos[i] = new Contacto(nombre, apellidos, direccion, empresa, telefono1, telefono2, email, fechaNacimeinto);
            }

            parsed = true;

        }catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parsed;
    }

    public Contacto[] getContactos() {
        return contactos;
    }
}
