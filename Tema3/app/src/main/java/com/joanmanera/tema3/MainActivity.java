package com.joanmanera.tema3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button boton;
    private EditText tvNombre;
    private EditText tvApellidos;


    @Override
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNombre = findViewById(R.id.etNombre);
        tvApellidos = findViewById(R.id.etApellidos);
        boton = findViewById(R.id.bSaluda);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String mensajeSaludo = "Hola "+tvNombre.getText().toString() + " " + tvApellidos.getText().toString();
                Toast.makeText(MainActivity.this, mensajeSaludo, Toast.LENGTH_LONG).show();
            }
        });
    }
}
