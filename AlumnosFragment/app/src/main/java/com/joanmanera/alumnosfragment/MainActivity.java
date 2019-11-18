package com.joanmanera.alumnosfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IAlumnosListener {

    private FragmentListado fragmentListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentListado = (FragmentListado)getSupportFragmentManager().findFragmentById(R.id.FrgListado);
        fragmentListado.setAlumnosListener(this);
    }

    @Override
    public void onAlumnoSeleccionado(int posicion) {
        boolean hayDetalle = (getSupportFragmentManager().findFragmentById(R.id.FrgDetalle) != null);
        Alumno a = fragmentListado.getAlumnos()[posicion];
        Asignatura[] asignaturas = fragmentListado.getAsignaturas();
        if (hayDetalle){
            FragmentDetalle fragmentDetalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.FrgDetalle);
            fragmentDetalle.mostrarDetalle(a.getNotas().values().toArray()[posicion].toString(), a.getNotas().get(a.getNotas().keySet().toArray()[posicion]), asignaturas);
        }else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, a);
            startActivity(i);
        }
    }
}
