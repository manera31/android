package com.joanmanera.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Dialogo extends DialogFragment {
    private TextView textView;
    private EditText etNLista;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        textView = getActivity().findViewById(R.id.id);
        etNLista = new EditText(getActivity());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(etNLista);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                textView.setText(etNLista.getText());
                //listener.onDialogPositiveClick(NombreListaDilog.this);
            }
        })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //listener.onDialogNegativeClick(NombreListaDilog.this);
                    }
                })
                .setTitle("Introduzca un Nombre");




        return builder.create();
    }
}