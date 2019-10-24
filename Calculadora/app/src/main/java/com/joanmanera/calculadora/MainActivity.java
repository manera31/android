package com.joanmanera.calculadora;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, buttonPunto, buttonC, buttonEqual;
    TextView resultado;

    float primerValor, segundoValor;

    boolean sumar, restar, multiplicar, dividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        button0 = findViewById(R.id.b0);
        button1 = findViewById(R.id.b1);
        button2 = findViewById(R.id.b2);
        button3 = findViewById(R.id.b3);
        button4 = findViewById(R.id.b4);
        button5 = findViewById(R.id.b5);
        button6 = findViewById(R.id.b6);
        button7 = findViewById(R.id.b7);
        button8 = findViewById(R.id.b8);
        button9 = findViewById(R.id.b9);
        buttonPunto = findViewById(R.id.bPunto);
        buttonAdd = findViewById(R.id.bSumar);
        buttonSub = findViewById(R.id.bRestar);
        buttonMul = findViewById(R.id.bMultiplicar);
        buttonDivision = findViewById(R.id.bDividir);
        buttonC = findViewById(R.id.bCE);
        buttonEqual = findViewById(R.id.bIgual);
        resultado = findViewById(R.id.tvOperacion);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonPunto.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b0:
                resultado.append("0");
                break;
            case R.id.b1:
                resultado.append("1");
                break;
            case R.id.b2:
                resultado.append("2");
                break;
            case R.id.b3:
                resultado.append("3");
                break;
            case R.id.b4:
                resultado.append("4");
                break;
            case R.id.b5:
                resultado.append("5");
                break;
            case R.id.b6:
                resultado.append("6");
                break;
            case R.id.b7:
                resultado.append("7");
                break;
            case R.id.b8:
                resultado.append("8");
                break;
            case R.id.b9:
                resultado.append("9");
                break;
            case R.id.bSumar:
                if (resultado == null) {
                    resultado.setText("");
                } else {
                    primerValor = Float.parseFloat(resultado.getText() + "");
                    sumar = true;
                    resultado.setText(null);
                }
                break;
            case R.id.bRestar:
                primerValor = Float.parseFloat(resultado.getText() + "");
                restar = true;
                resultado.setText(null);
                break;
            case R.id.bMultiplicar:
                primerValor = Float.parseFloat(resultado.getText() + "");
                multiplicar = true;
                resultado.setText(null);
                break;
            case R.id.bDividir:
                primerValor = Float.parseFloat(resultado.getText() + "");
                dividir = true;
                resultado.setText(null);
            case R.id.bCE:
                resultado.setText("");
                break;
            case R.id.bPunto:
                resultado.append(".");

                break;
            case R.id.bIgual:
                segundoValor = Float.parseFloat(resultado.getText() + "");

                if (sumar == true) {
                    resultado.setText(primerValor + segundoValor +"");

                    sumar = false;
                }

                if (restar == true) {
                    resultado.setText(primerValor - segundoValor +"");
                    restar = false;
                }

                if (multiplicar == true) {
                    resultado.setText(primerValor * segundoValor +"");

                    multiplicar = false;
                }

                if (dividir == true) {
                    resultado.setText(primerValor / segundoValor +"");

                    dividir = false;
                }
                break;
        }
    }
}