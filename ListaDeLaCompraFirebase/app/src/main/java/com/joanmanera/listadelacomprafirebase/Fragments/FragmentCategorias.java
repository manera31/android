package com.joanmanera.listadelacomprafirebase.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.joanmanera.listadelacomprafirebase.Adapters.AdapterCategoria;
import com.joanmanera.listadelacomprafirebase.Interfaces.ICategoryListListener;
import com.joanmanera.listadelacomprafirebase.Models.CategoriaProducto;
import com.joanmanera.listadelacomprafirebase.R;

public class FragmentCategorias extends Fragment {
    public static final int SPAN_COUNT = 3;

    private AdapterCategoria adapterCategoria;
    private RecyclerView recyclerView;
    private ICategoryListListener listener;

    private FirebaseFirestore db;
    private CollectionReference ref;

    public FragmentCategorias(ICategoryListListener listener){
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_category, container, false);

        // Buscamos las categorías, las ordenamos por su nombre, creamos su adaptador y de las pasamos.
        db = FirebaseFirestore.getInstance();
        ref = db.collection("categorias");
        Query query = ref.orderBy("nombreCategoria", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<CategoriaProducto> options = new FirestoreRecyclerOptions.Builder<CategoriaProducto>()
                .setQuery(query, CategoriaProducto.class)
                .build();

        adapterCategoria = new AdapterCategoria(options, listener, getActivity());

        recyclerView = view.findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), SPAN_COUNT));
        recyclerView.setAdapter(adapterCategoria);

        // El adaptador empieza a escuchar a la base de datos.
        adapterCategoria.startListening();

        return view;
    }

    @Override
    public void onStop() {

        // Cuando la app se para, el adapter parará de eschuchar a la base de datos.
        super.onStop();
        if (adapterCategoria != null){
            adapterCategoria.stopListening();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        // Cuando se reanude la app, el adaptador reanudará la eschucha a la base de datos.
        if (adapterCategoria != null){
            adapterCategoria.startListening();
        }
    }
}
