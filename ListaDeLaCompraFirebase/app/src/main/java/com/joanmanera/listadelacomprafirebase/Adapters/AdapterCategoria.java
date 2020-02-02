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
import com.joanmanera.listadelacomprafirebase.Models.CategoriaProducto;
import com.joanmanera.listadelacomprafirebase.R;

public class AdapterCategoria extends FirestoreRecyclerAdapter<CategoriaProducto, AdapterCategoria.CategoriaHolder> {

    private ICategoryListListener listener;
    private Context context;

    public AdapterCategoria(@NonNull FirestoreRecyclerOptions<CategoriaProducto> options, ICategoryListListener listener, Context context) {
        super(options);
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected void onBindViewHolder(@NonNull CategoriaHolder categoriaHolder, int i, @NonNull CategoriaProducto categoriaProducto) {
        categoriaHolder.tvNombreCategoria.setText(categoriaProducto.getNombreCategoria());

        // Busco la id de la imagen de la categoría para mostrarla.
        int id = context.getResources().getIdentifier("drawable/"+categoriaProducto.getNombreCategoria(), "drawable", context.getPackageName());
        categoriaHolder.ivImagenCategoria.setImageDrawable(context.getResources().getDrawable(id));
    }

    @NonNull
    @Override
    public CategoriaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_category_list, parent, false);
        return new CategoriaHolder(v);
    }

    class CategoriaHolder extends RecyclerView.ViewHolder {
        TextView tvNombreCategoria;
        ImageView ivImagenCategoria;

        public CategoriaHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreCategoria = itemView.findViewById(R.id.tvNameProductCategory);
            ivImagenCategoria = itemView.findViewById(R.id.ivProductCategoryImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition() != RecyclerView.NO_POSITION && listener != null) {
                        listener.onCategoryListSelected(getSnapshots().getSnapshot(getAdapterPosition()), getAdapterPosition());
                    }
                }
            });
        }
    }
}
