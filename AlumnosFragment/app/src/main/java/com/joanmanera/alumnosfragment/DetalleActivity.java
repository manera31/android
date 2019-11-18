package com.joanmanera.alumnosfragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    public static final String EXTRA_TEXTO = "com.joanmanera.alumnosfragment.EXTRA_TEXTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        FragmentDetalle detalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.FrgDetalle);
        Alumno a = (Alumno)getIntent().getSerializableExtra(EXTRA_TEXTO);
        detalle.mostrarDetalle(a.getNotas());
    }
}