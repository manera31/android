package com.joanmanera.listacontactos;

import android.content.Context;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;

public class AdaptadorContactos extends ArrayAdapter<Contacto> {
    private Context context;
    private Contacto[] contactos;

    public AdaptadorContactos(@NonNull Fragment context, Contacto[] contactos) {
        super(context.getActivity(), R.layout.listitem_contacto, contactos);
        this.contactos = contactos;
        this.context = context.getActivity();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.listitem_contacto, null);

        TextView tvNombre = item.findViewById(R.id.tvNombre);
        tvNombre.setText(contactos[position].getNombre());

        TextView tvTelefono1 = item.findViewById(R.id.tvTelefono);
        tvTelefono1.setText(contactos[position].getTelefono1());

        return item;
    }
}