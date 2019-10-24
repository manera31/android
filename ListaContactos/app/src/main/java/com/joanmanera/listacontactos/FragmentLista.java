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

    private Contacto[] contactos;

    private ListView listView;

    private IContactosListener listener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = getView().findViewById(R.id.LstListado);

        ContactParser contactParser = new ContactParser(getActivity());//Falta poner el contexto
        if(contactParser.parse()){
            contactos = contactParser.getContactos();
        }

        listView.setAdapter(new AdaptadorContactos(this, contactos));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(listener != null){
                    listener.onContactoListener((Contacto)listView.getAdapter().getItem(i));
                }
            }
        });

    }

    public void setContactosListener(IContactosListener listener){
        this.listener = listener;
    }
}
