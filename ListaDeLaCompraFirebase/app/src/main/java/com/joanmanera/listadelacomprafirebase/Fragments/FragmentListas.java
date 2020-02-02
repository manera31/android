package com.joanmanera.listadelacomprafirebase.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.joanmanera.listadelacomprafirebase.Adapters.AdapterListas;
import com.joanmanera.listadelacomprafirebase.Interfaces.IListListener;
import com.joanmanera.listadelacomprafirebase.Models.ListaCompra;
import com.joanmanera.listadelacomprafirebase.R;

public class FragmentListas extends Fragment {

    private AdapterListas adapterListas;
    private RecyclerView recyclerView;
    private Button bAddList;
    private EditText etNameList;

    private FirebaseFirestore db;
    private CollectionReference ref;

    private IListListener listener;

    public FragmentListas(IListListener listener){
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // Buscamos las listas, las ordenamos por fechas ascendientemente, creamos el adapter y se las pasamos al recycler view.
        db = FirebaseFirestore.getInstance();
        ref = db.collection("listas");
        Query query = ref.orderBy("time", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<ListaCompra> options = new FirestoreRecyclerOptions.Builder<ListaCompra>()
                .setQuery(query, ListaCompra.class)
                .build();

        adapterListas = new AdapterListas(options, listener);

        recyclerView = view.findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapterListas);

        // El adaptador empieza a escuchar a la base de datos.
        adapterListas.startListening();

        etNameList = view.findViewById(R.id.etNameList);

        // Botón para controlar cuando el usuario quiere añadir mas listas.
        bAddList = view.findViewById(R.id.bAddList);
        bAddList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etNameList.getText().toString().equals("")) {
                    ListaCompra lc = new ListaCompra(etNameList.getText().toString());
                    ref.add(lc);
                    etNameList.setText("");
                }
            }
        });

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();

        // Cuando la app se para, el adapter parará de eschuchar a la base de datos.
        if(adapterListas != null) {
            adapterListas.stopListening();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        // Cuando se reanude la app, el adaptador reanudará la eschucha a la base de datos.
        if (adapterListas != null){
            adapterListas.startListening();
        }
    }
}
