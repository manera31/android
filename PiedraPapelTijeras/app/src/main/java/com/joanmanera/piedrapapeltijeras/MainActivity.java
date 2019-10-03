package com.joanmanera.piedrapapeltijeras;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;
    private ImageButton ibPapel;
    private ImageButton ibPiedra;
    private ImageButton ibTijera;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tvTitulo);
        ibPiedra = findViewById(R.id.ibPiedra);
        ibPapel = findViewById(R.id.ibPapel);
        ibTijera = findViewById(R.id.ibTijera);
        tvResultado = findViewById(R.id.tvResultado);

        ibPapel.setOnClickListener(this);
        ibPiedra.setOnClickListener(this);
        ibTijera.setOnClickListener(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View v){
        Random random = new Random();
        int resultado = random.nextInt(3);

        switch (v.getId()){
            case R.id.ibPiedra:
                if(resultado == 0){
                    tvResultado.setText(R.string.mensajeEmpate);
                } else if(resultado == 1){
                    tvResultado.setText(R.string.mensajePerdedor);
                } else {
                    tvResultado.setText(R.string.mensajeGanador);

                }
                break;
            case R.id.ibPapel:
                if(resultado == 0){
                    tvResultado.setText(R.string.mensajeGanador);
                } else if(resultado == 1){
                    tvResultado.setText(R.string.mensajeEmpate);
                } else {
                    tvResultado.setText(R.string.mensajePerdedor);

                }
                break;
            case R.id.ibTijera:
                if(resultado == 0){
                    tvResultado.setText(R.string.mensajePerdedor);
                } else if(resultado == 1){
                    tvResultado.setText(R.string.mensajeGanador);
                } else {
                    tvResultado.setText(R.string.mensajeEmpate);

                }
                break;

            default:
                break;
        }
        if(resultado == 0){
            Toast.makeText(MainActivity.this, "Ha salido PIEDRA", Toast.LENGTH_LONG).show();
        } else if(resultado == 1){
            Toast.makeText(MainActivity.this, "Ha salido PAPEL", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Ha salido TIJERA", Toast.LENGTH_LONG).show();

        }
    }
}
