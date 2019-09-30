package com.joanmanera.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button boton;
    private TextView tvSaluda;
    private TextView tvAs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maymain);

        tvSaluda = findViewById(R.id.editText);
        tvAs = findViewById(R.id.editText2);


        /*boton = findViewById(R.id.button);
        tvSaluda = findViewById(R.id.tvSaluda);

        tvSaluda.setText("Mensaje");

        boton.setText("Saluda");


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "holaa", Toast.LENGTH_LONG).show();
            }
        });




        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();
        Log.d(MainActivity.this.getLocalClassName() ,"onCreate()");*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show();

        Log.d(MainActivity.this.getLocalClassName() ,"onStart()");
    }

}
