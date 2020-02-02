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
import com.joanmanera.listadelacomprafirebase.Adapters.AdapterProducto;
import com.joanmanera.listadelacomprafirebase.Interfaces.ICategoryListListener;
import com.joanmanera.listadelacomprafirebase.Interfaces.IProductListListener;
import com.joanmanera.listadelacomprafirebase.Models.CategoriaProducto;
import com.joanmanera.listadelacomprafirebase.R;

public class FragmentProductos extends Fragment {
    public static final int SPAN_COUNT = 3;

    private AdapterProducto adapterProducto;
    private RecyclerView recyclerView;
    private IProductListListener listener;
    private String nombreCategoria;

    private FirebaseFirestore db;
    private CollectionReference ref;

    public FragmentProductos(IProductListListener listener, String nombreCategoria){
        this.listener = listener;
        this.nombreCategoria = nombreCategoria;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_category, container, false);

        // Buscamos los productos de la categoría seleccionada, los ordenamos, creamos el adaptador y se los pasamos.
        db = FirebaseFirestore.getInstance();
        ref = db.collection("categoria_producto");
        Query query = ref.whereEqualTo("nombreCategoria", nombreCategoria).orderBy("nombreProducto", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<CategoriaProducto> options = new FirestoreRecyclerOptions.Builder<CategoriaProducto>()
                .setQuery(query, CategoriaProducto.class)
                .build();

        adapterProducto = new AdapterProducto(options, listener, getActivity());

        recyclerView = view.findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), SPAN_COUNT));
        recyclerView.setAdapter(adapterProducto);

        // El adaptador empieza a escuchar a la base de datos.
        adapterProducto.startListening();

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();

        // Cuando la app se para, el adapter parará de eschuchar a la base de datos.
        if (adapterProducto != null){
            adapterProducto.stopListening();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        // Cuando se reanude la app, el adaptador reanudará la eschucha a la base de datos.
        if (adapterProducto != null){
            adapterProducto.startListening();
        }
    }
}
