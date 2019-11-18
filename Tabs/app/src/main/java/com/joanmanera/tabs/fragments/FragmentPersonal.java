package com.joanmanera.tabs.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.joanmanera.tabs.R;
import com.joanmanera.tabs.modelos.Trabajador;

public class FragmentPersonal extends Fragment {
    public static final String PLACEHOLDER_TAB1 = "com.joanmanera.tabs.fragments.tab1";
    private ImageView ivFoto;
    private TextView tvNombre;
    private TextView tvApellidos;
    private TextView tvFechaNacimiento;
    private TextView tvDireccion;
    private TextView tvNif;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.item_personal, container, false);

        tvNombre = layout.findViewById(R.id.tvNombre);
        tvApellidos = layout.findViewById(R.id.tvApellidos);
        tvFechaNacimiento = layout.findViewById(R.id.tvFechaNacimiento);
        tvDireccion = layout.findViewById(R.id.tvDireccion);
        tvNif = layout.findViewById(R.id.tvNif);

        Trabajador trabajador = (Trabajador) getArguments().getSerializable(PLACEHOLDER_TAB1);

        tvNombre.setText(trabajador.getNombre());
        tvApellidos.setText(trabajador.getApellidos());
        tvFechaNacimiento.setText(trabajador.getFechaNacimiento());
        tvDireccion.setText(trabajador.getDireccion());
        tvNif.setText(trabajador.getNif());

        return layout;
    }
}
