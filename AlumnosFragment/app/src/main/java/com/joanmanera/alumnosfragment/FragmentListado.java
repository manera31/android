package com.joanmanera.alumnosfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentListado extends Fragment {
    private Alumno[] alumnos;
    private Asignatura[] asignaturas
    private RecyclerView rvListado;
    private IAlumnosListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AlumnosParser parser = new AlumnosParser(getActivity());
        if (parser.parse()){
            this.alumnos = parser.getAlumnos();
            this.asignaturas = parser.getAsignaturas();
        }
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvListado = getView().findViewById(R.id.RvListado);
        rvListado.setAdapter(new AdaptadorListaAlumnos(alumnos, listener));
        rvListado.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    public void setAlumnosListener(IAlumnosListener listener) {
        this.listener = listener;
    }

    public Alumno[] getAlumnos(){
        return alumnos;
    }

    public Asignatura[] getAsignaturas(){
        return asignaturas;
    }

}
