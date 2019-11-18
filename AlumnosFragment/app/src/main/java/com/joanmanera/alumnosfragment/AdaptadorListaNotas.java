package com.joanmanera.alumnosfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Dictionary;
import java.util.HashMap;

public class AdaptadorListaNotas extends RecyclerView.Adapter<AdaptadorListaNotas.NotasViewHolder> {

    private String codAsignatura;
    private String nomAsignatura;
    private Double nota;

    public AdaptadorListaNotas(String codAsignatura, String nomAsignatura, Double nota) {
        this.codAsignatura = codAsignatura;
        this.nomAsignatura = nomAsignatura;
        this.nota = nota;
    }

    @NonNull
    @Override
    public NotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nota, parent, false);
        return new NotasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotasViewHolder holder, int position) {
        holder.bindNotas(notas.values().toArray()[position].toString(), notas.get(notas.keySet().toArray()[position]));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class NotasViewHolder extends RecyclerView.ViewHolder{

        private TextView tvCodigoAsignatura;
        private TextView tvNombreAsignatura;
        private TextView tvNota;

        public NotasViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCodigoAsignatura = itemView.findViewById(R.id.tvCodigoAsignatura);
            tvNombreAsignatura = itemView.findViewById(R.id.tvNombreAsignatura);
            tvNota = itemView.findViewById(R.id.tvNota);
        }

        public void bindNotas(String codAsignatura, String nomAsignaturas, Double nota){
            tvCodigoAsignatura.setText(codAsignatura);
            tvNombreAsignatura.setText(nomAsignaturas);//todo
            tvNota.setText(nota.toString());
        }
    }
}
