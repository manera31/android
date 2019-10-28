package com.joanmanera.listacontactos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorContactosRecyclerView extends RecyclerView.Adapter<AdaptadorContactosRecyclerView.ContactViewHolder> implements View.OnClickListener {

    private Context context;
    private Contacto[] contactos;

    public AdaptadorContactosRecyclerView(Context context, Contacto[] contactos) {
        this.context = context;
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_listado, parent, false);

        itemView.setOnClickListener(this);

        ContactViewHolder contactViewHolder = new ContactViewHolder(itemView, context);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contacto contacto = contactos[position];
        holder.bindContact(contacto);
    }


    @Override
    public int getItemCount() {
        return contactos.length;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivFoto;
        private TextView tvNombre;
        private TextView tvApellido;
        private TextView tvDireccion;
        private TextView tvEmpresa;
        private TextView tvFechaNacimiento;
        private TextView tvTelefono1;
        private TextView tvTelefono2;
        private TextView tvEmail;

        private Context context;


        public ContactViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;

            ivFoto = itemView.findViewById(R.id.ivFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellido = itemView.findViewById(R.id.tvApellidos);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvEmpresa = itemView.findViewById(R.id.tvEmpresa);
            tvFechaNacimiento = itemView.findViewById(R.id.tvFechaNacimiento);
            tvTelefono1 = itemView.findViewById(R.id.tvTelefono1);
            tvTelefono2 = itemView.findViewById(R.id.tvTelefonno2);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }

        public void bindContact(Contacto contacto){
            ivFoto.setImageResource(R.drawable.profile);

        }
    }
}
