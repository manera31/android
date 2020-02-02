package com.joanmanera.listadelacomprafirebase.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.joanmanera.listadelacomprafirebase.Adapters.AdapterProductoLista;
import com.joanmanera.listadelacomprafirebase.Interfaces.IProductoComprado;
import com.joanmanera.listadelacomprafirebase.Models.ListaCompra;
import com.joanmanera.listadelacomprafirebase.Models.ProductoLista;
import com.joanmanera.listadelacomprafirebase.R;

public class FragmentProductoLista extends Fragment {
    public static final int SPAN_COUNT = 3;

    private AdapterProductoLista adapterProductoLista;
    private RecyclerView recyclerView;
    private Button bAddProduct;
    private FirebaseFirestore db;
    private CollectionReference ref;
    private String nameList;
    private View.OnClickListener onClickListener;
    private IProductoComprado listener;

    public FragmentProductoLista (String nameList, View.OnClickListener onClickListener, IProductoComprado listener){
        this.nameList = nameList;
        this.onClickListener = onClickListener;
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list_cart, container, false);

        // Buscamos los productos de la lista que le pasamos, creamos el adaptaror y se las pasamos.
        db = FirebaseFirestore.getInstance();
        ref = db.collection("producto_lista");
        Query query = ref.whereEqualTo("nombreLista", nameList);

        FirestoreRecyclerOptions<ProductoLista> options = new FirestoreRecyclerOptions.Builder<ProductoLista>()
                .setQuery(query, ProductoLista.class)
                .build();

        adapterProductoLista = new AdapterProductoLista(options, listener, getActivity());

        recyclerView = view.findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), SPAN_COUNT));
        recyclerView.setAdapter(adapterProductoLista);

        // El adaptador empieza a escuchar a la base de datos.
        adapterProductoLista.startListening();

        // Botón para controlar cuando el usuario quiere añadir productos a la lista.
        bAddProduct = view.findViewById(R.id.bAddProducts);
        bAddProduct.setOnClickListener(onClickListener);

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();

        // Cuando la app se para, el adapter parará de eschuchar a la base de datos.
        if(adapterProductoLista != null) {
            adapterProductoLista.stopListening();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        // Cuando se reanude la app, el adaptador reanudará la eschucha a la base de datos.
        if (adapterProductoLista != null){
            adapterProductoLista.startListening();
        }
    }
}
