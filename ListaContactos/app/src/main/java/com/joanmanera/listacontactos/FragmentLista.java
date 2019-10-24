package com.joanmanera.listacontactos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;

public class FragmentLista extends Fragment {

    private Contacto[] contactos = getContactos();

    private ListView listView;

    private IContactosListener listener;

    private Contacto[] getContactos(){
        ContactParser contactParser = new ContactParser();//Falta poner el contexto
        try {
            if(contactParser.parse()){
                return getContactos();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = getView().findViewById(R.id.LstListado);
        listView.setAdapter(new AdaptadorContactos(this, contactos));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(listener != null){
                    listener.onContactoListener((Contacto)adapterView.getItemAtPosition(i));
                }
            }
        });

    }

    public void setOnCorreoListener(IContactosListener listener){
        this.listener = listener;
    }
}
