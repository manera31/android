package com.joanmanera.factorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {
    private EditText etNum;
    private Button bCalcula;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum = findViewById(R.id.etNum);
        bCalcula = findViewById(R.id.bCalcula);
        tvResultado = findViewById(R.id.tvResultado);

        bCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int numero = Integer.parseInt(etNum.getText().toString());

                if(numero == 0){
                    tvResultado.setText(""+0);
                } else {
                    long resultado = 1;

                    for (int i = 1 ; i <= numero ; i++){
                        resultado *= i;
                    }

                    tvResultado.setText(""+resultado);
                }



            }
        });
    }
}
