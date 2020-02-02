package com.joanmanera.listadelacomprafirebase.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.joanmanera.listadelacomprafirebase.Interfaces.IProductoComprado;
import com.joanmanera.listadelacomprafirebase.Models.ProductoLista;
import com.joanmanera.listadelacomprafirebase.R;

public class AdapterProductoLista extends FirestoreRecyclerAdapter<ProductoLista, AdapterProductoLista.ProductoListaHolder> {

    private Context context;
    private IProductoComprado listener;

    public AdapterProductoLista(@NonNull FirestoreRecyclerOptions<ProductoLista> options, IProductoComprado listener, Context context) {
        super(options);
        this.listener = listener;
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ProductoListaHolder productoListaHolder, int i, @NonNull ProductoLista productoLista) {
        productoListaHolder.tvNombreProducto.setText(productoLista.getNombreProducto());

        int id = context.getResources().getIdentifier("drawable/"+productoLista.getNombreProducto(), "drawable", context.getPackageName());
        productoListaHolder.ivProductImage.setImageDrawable(context.getResources().getDrawable(id));

        productoListaHolder.cbComprado.setChecked(productoLista.isEstaComprada());
    }

    @NonNull
    @Override
    public ProductoListaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto_lista, parent, false);
        return new ProductoListaHolder(v);
    }

    class ProductoListaHolder extends RecyclerView.ViewHolder{
        ImageView ivProductImage;
        TextView tvNombreProducto;
        CheckBox cbComprado;

        public ProductoListaHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreProducto = itemView.findViewById(R.id.tvNameProductList);
            ivProductImage = itemView.findViewById(R.id.ivProductListImage);
            cbComprado = itemView.findViewById(R.id.cbComprado);
            cbComprado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition() != RecyclerView.NO_POSITION && listener != null) {
                        listener.onProductoComprado(getSnapshots().getSnapshot(getAdapterPosition()), cbComprado.isChecked());
                    }
                }
            });
        }
    }
}
