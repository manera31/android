package com.joanmanera.listacontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IContactosListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentLista fragmentLista = (FragmentLista)getSupportFragmentManager().findFragmentById(R.id.FrgListado);
        fragmentLista.setOnCorreoListener(this);
    }

    @Override
    public void onContactoListener(Contacto contacto) {
        boolean hayDetalle = getSupportFragmentManager().findFragmentById(R.id.FrgDetalle) != null;
        if (hayDetalle){
            ((FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)).mostrarDetalle(contacto);
        } else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, o.getTexto());
            startActivity(i);
        }
    }
}
