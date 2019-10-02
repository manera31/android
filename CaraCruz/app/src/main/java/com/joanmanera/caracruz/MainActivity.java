package com.joanmanera.caracruz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button bHead;
    private Button bTails;
    private TextView tvResult;
    private ImageView iImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bHead = findViewById(R.id.bHead);
        bTails = findViewById(R.id.bTails);
        tvResult = findViewById(R.id.tvResult);
        iImage = findViewById(R.id.imageView);

        bHead.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if (generarSorteo() == 0){
                    iImage.setImageResource(R.drawable.euro_cara);
                    tvResult.setText(R.string.mensajeGanador);

                } else {
                    iImage.setImageResource(R.drawable.euro_cruz);
                    tvResult.setText(R.string.mensajePerdedor);

                }
            }
        });

        bTails.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if (generarSorteo() == 0){
                    iImage.setImageResource(R.drawable.euro_cara);
                    tvResult.setText(R.string.mensajePerdedor);

                } else {
                    iImage.setImageResource(R.drawable.euro_cruz);
                    tvResult.setText(R.string.mensajeGanador);

                }
            }
        });
    }

    private int generarSorteo(){
        Random rdn = new Random();
        return rdn.nextInt(2);
    }
}
