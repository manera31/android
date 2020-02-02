package com.joanmanera.listadelacomprafirebase.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.joanmanera.listadelacomprafirebase.Interfaces.ICategoryListListener;
import com.joanmanera.listadelacomprafirebase.Interfaces.IProductListListener;
import com.joanmanera.listadelacomprafirebase.Models.CategoriaProducto;
import com.joanmanera.listadelacomprafirebase.R;

public class AdapterProducto extends FirestoreRecyclerAdapter<CategoriaProducto, AdapterProducto.ProductoHolder> {
    private IProductListListener listener;
    private Context context;

    public AdapterProducto(@NonNull FirestoreRecyclerOptions<CategoriaProducto> options, IProductListListener listener, Context context) {
        super(options);
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterProducto.ProductoHolder productoHolder, int i, @NonNull CategoriaProducto categoriaProducto) {
        productoHolder.tvNombreProducto.setText(categoriaProducto.getNombreProducto());

        // Busco la id de la imagen del producto para mostrarla.
        int id = context.getResources().getIdentifier("drawable/"+categoriaProducto.getNombreProducto(), "drawable", context.getPackageName());
        productoHolder.ivImagenProducto.setImageDrawable(context.getResources().getDrawable(id));
    }

    @NonNull
    @Override
    public AdapterProducto.ProductoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_category_list, parent, false);
        return new AdapterProducto.ProductoHolder(v);
    }

    class ProductoHolder extends RecyclerView.ViewHolder {
        TextView tvNombreProducto;
        ImageView ivImagenProducto;

        public ProductoHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreProducto = itemView.findViewById(R.id.tvNameProductCategory);
            ivImagenProducto = itemView.findViewById(R.id.ivProductCategoryImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition() != RecyclerView.NO_POSITION && listener != null) {
                        listener.onProductListSelected(getSnapshots().getSnapshot(getAdapterPosition()), getAdapterPosition());
                    }
                }
            });
        }
    }
}

