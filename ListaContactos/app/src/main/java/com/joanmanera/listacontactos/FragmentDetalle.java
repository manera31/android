package com.joanmanera.listacontactos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetalle extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

    public void mostrarDetalle(Contacto contacto){
        ImageView ivFoto = getView().findViewById(R.id.ivFoto);
        ivFoto.setImageResource(R.drawable.profile);

        TextView tvNombre = getView().findViewById(R.id.tvNombre);
        tvNombre.setText(contacto.getNombre());

        TextView tvApellido = getView().findViewById(R.id.tvApellidos);
        tvApellido.setText(contacto.getApellidos());

        TextView tvDireccion = getView().findViewById(R.id.tvDireccion);
        tvDireccion.setText(contacto.getDireccion());

        TextView tvEmpresa = getView().findViewById(R.id.tvEmpresa);
        tvEmpresa.setText(contacto.getEmpresa());

        TextView tvFechaNacimiento = getView().findViewById(R.id.tvFechaNacimiento);
        tvFechaNacimiento.setText(contacto.getFechaNacimiento());

        TextView tvTelefono1 = getView().findViewById(R.id.tvTelefono1);
        tvTelefono1.setText(contacto.getTelefono1());

        TextView tvTelefono2 = getView().findViewById(R.id.tvTelefonno2);
        tvTelefono2.setText(contacto.getTelefono2());

        TextView tvEmail = getView().findViewById(R.id.tvEmail);
        tvEmail.setText(contacto.getEmail());
    }
}
