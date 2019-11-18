package com.joanmanera.tabs.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.joanmanera.tabs.R;
import com.joanmanera.tabs.modelos.Trabajador;

public class FragmentProfesional extends Fragment {
    public static final String PLACEHOLDER_TAB2 = "com.joanmanera.tabs.fragments.tab2";
    private TextView tvRazonSocial;
    private TextView tvCif;
    private TextView tvDireccion;
    private TextView tvWeb;
    private TextView tvEmail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.item_profesional, container, false);

        tvRazonSocial = layout.findViewById(R.id.tvRazonSocial);
        tvCif = layout.findViewById(R.id.tvCif);
        tvDireccion = layout.findViewById(R.id.tvDireccionEmpresa);
        tvWeb = layout.findViewById(R.id.tvWeb);
        tvEmail = layout.findViewById(R.id.tvMail);

        /*Trabajador trabajador = (Trabajador) getArguments().getSerializable(PLACEHOLDER_TAB2);


        tvRazonSocial.setText(trabajador.getEmpresa().getRazonSocial());
        tvCif.setText(trabajador.getEmpresa().getCif());
        tvDireccion.setText(trabajador.getEmpresa().getDireccion());
        tvWeb.setText(trabajador.getEmpresa().getWeb());
        tvEmail.setText(trabajador.getEmpresa().getCorreoElectronico());*/

        return layout;
    }
}
