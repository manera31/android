package com.joanmanera.alumnosfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

public class FragmentDetalle extends Fragment {

    private RecyclerView rvDetalle;
    private TextView codAsig;
    private TextView nomAsig;
    private TextView nota;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);
        rvDetalle = view.findViewById(R.id.RvDetalle);
        codAsig = view.findViewById(R.id.tvCodigoAsignatura);
        nomAsig = view.findViewById(R.id.tvNombreAsignatura);
        nota = view.findViewById(R.id.tvNota);
        return view;
    }

    public void mostrarDetalle(String codAsignatura, Double nota, Asignatura[] asignaturas){

        boolean aux = false;

        for (int i = 0 ; i < asignaturas.length ; i++){
            if (asignaturas[i].getCodigoAsignatura().equals(codAsignatura)) {
                rvDetalle.setAdapter(new AdaptadorListaNotas(map));
                codAsig.setText(codAsignatura);
                nomAsig.setText(asignaturas[i].getNombreAsignatura());
                this.nota.setText(nota.toString());
                aux = true;
            }
        }

        if(!aux){
            rvDetalle.setAdapter(new AdaptadorListaNotas(map));
            codAsig.setText("");
            nomAsig.setText("");
            this.nota.setText("");
        }

    }
}
