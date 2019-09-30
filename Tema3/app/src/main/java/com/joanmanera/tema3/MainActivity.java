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
    private EditText etNombre;
    private EditText etApellidos;


    @Override
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        boton = findViewById(R.id.bSaluda);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String mensajeSaludo = "Hola "+etNombre.getText().toString() + " " + etApellidos.getText().toString();
                Toast.makeText(MainActivity.this, mensajeSaludo, Toast.LENGTH_LONG).show();
            }
        });
    }
}
