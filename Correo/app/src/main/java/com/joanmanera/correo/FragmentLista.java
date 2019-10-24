package com.joanmanera.correo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentLista extends Fragment {

    private ICorreosListener listener;

    private Correo[] datos = new Correo[]{
            new Correo("Persona 1", "Asunto 1", "Texto 1"),
            new Correo("Persona 2", "Asunto 2", "Texto 2"),
            new Correo("Persona 3", "Asunto 3", "Texto 3"),
            new Correo("Persona 4", "Asunto 4", "Texto 4"),
            new Correo("Persona 5", "Asunto 5", "Texto 5")
    };
    private ListView lstListado;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lstListado = getView().findViewById(R.id.LstListado);
        lstListado.setAdapter(new AdaptadorCorreos(this, datos));
        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(listener != null){
                    listener.onCorreoSeleccionado((Correo)adapterView.getItemAtPosition(i));
                }
            }
        });
    }
    public void setOnCorreosListener(ICorreosListener listener){
        this.listener = listener;
    }

}
