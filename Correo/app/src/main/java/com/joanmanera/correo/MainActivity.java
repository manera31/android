package com.joanmanera.correo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ICorreosListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentLista frgListado = (FragmentLista)getSupportFragmentManager().findFragmentById(R.id.FrgListado);
        frgListado.setOnCorreosListener(this);
    }

    @Override
    public void onCorreoSeleccionado(Correo o) {
        boolean hayDetalle = getSupportFragmentManager().findFragmentById(R.id.FrgDetalle) != null;
        if (hayDetalle){
            ((FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)).mostrarDetalle(o.getTexto());
        } else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, o.getTexto());
            startActivity(i);
        }
    }
}
