package com.joanmanera.tabs.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.joanmanera.tabs.R;
import com.joanmanera.tabs.modelos.Trabajador;

public class FragmentAcceso extends Fragment {
    public static final String PLACEHOLDER_TAB3 = "com.joanmanera.tabs.fragments.tab3";
    private EditText etUsuario;
    private Button bCambiarContraseña;
    private EditText etAntiguaContraseña;
    private EditText etNuevaContraseña;
    private EditText etRepetirContraseña;
    private TextView tvCampo1;
    private TextView tvCampo2;
    private TextView tvCampo3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.item_acceso, container, false);

        etUsuario = layout.findViewById(R.id.etUsuario);
        bCambiarContraseña = layout.findViewById(R.id.bCambiarContraseña);
        etAntiguaContraseña = layout.findViewById(R.id.etContraseñaAntigua);
        etNuevaContraseña = layout.findViewById(R.id.etNuevaContraseña);
        etRepetirContraseña = layout.findViewById(R.id.etRepetirContraseña);
        tvCampo1 = layout.findViewById(R.id.tvCampoNuevaContraseña);
        tvCampo2 = layout.findViewById(R.id.tvCampoRepetirContraseña);
        tvCampo3 = layout.findViewById(R.id.tvCampoContraseñaAntigua);

        //Trabajador trabajador = (Trabajador) getArguments().getSerializable(PLACEHOLDER_TAB3);

        etAntiguaContraseña.setVisibility(View.INVISIBLE);
        etNuevaContraseña.setVisibility(View.INVISIBLE);
        etRepetirContraseña.setVisibility(View.INVISIBLE);
        tvCampo3.setVisibility(View.INVISIBLE);
        tvCampo2.setVisibility(View.INVISIBLE);
        tvCampo1.setVisibility(View.INVISIBLE);

        return layout;
    }
}
