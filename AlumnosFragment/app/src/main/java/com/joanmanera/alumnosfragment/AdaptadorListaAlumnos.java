package com.joanmanera.alumnosfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorListaAlumnos extends RecyclerView.Adapter<AdaptadorListaAlumnos.AlumnosViewHolder> {

    private Alumno[] alumnos;
    private IAlumnosListener listener;

    public AdaptadorListaAlumnos(Alumno[] alumnos, IAlumnosListener listener) {
        this.alumnos = alumnos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlumnosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alumno, parent, false);
        return new AlumnosViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnosViewHolder holder, int position) {
        holder.bindAlumno(alumnos[position]);
    }

    @Override
    public int getItemCount() {
        return alumnos.length;
    }

    public static class AlumnosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvNombre;
        private TextView tvEmail;
        private TextView tvEdad;
        private IAlumnosListener listener;

        public AlumnosViewHolder(@NonNull View itemView, IAlumnosListener listener) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvEdad = itemView.findViewById(R.id.tvEdad);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bindAlumno(Alumno alumno){
            tvNombre.setText(alumno.getNombre());
            tvEmail.setText(alumno.getEmail());
            tvEdad.setText(alumno.getEdad());
        }

        @Override
        public void onClick(View v) {
            if (listener != null){
                listener.onAlumnoSeleccionado(getAdapterPosition());
            }
        }
    }
}
