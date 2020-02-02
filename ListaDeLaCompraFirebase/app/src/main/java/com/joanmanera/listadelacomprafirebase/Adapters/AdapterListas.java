package com.joanmanera.listadelacomprafirebase.Adapters;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.joanmanera.listadelacomprafirebase.Interfaces.IListListener;
import com.joanmanera.listadelacomprafirebase.Models.ListaCompra;
import com.joanmanera.listadelacomprafirebase.R;

import java.util.Date;

public class AdapterListas extends FirestoreRecyclerAdapter<ListaCompra, AdapterListas.ListHolder> {

    private IListListener listener;


    public AdapterListas(@NonNull FirestoreRecyclerOptions<ListaCompra> options, IListListener listener) {
        super(options);
        this.listener = listener;
    }

    @Override
    protected void onBindViewHolder(@NonNull ListHolder listHolder, int i, @NonNull ListaCompra list) {
        listHolder.tvName.setText(list.getName());
        Date date = new Date(list.getTime());
        listHolder.tvDate.setText(DateFormat.format("dd/MM/yyyy HH:mm", date));
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ListHolder(v);
    }

    class ListHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvDate;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNameList);
            tvDate = itemView.findViewById(R.id.tvDataList);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition() != RecyclerView.NO_POSITION && listener != null){
                        listener.onListSelected(getSnapshots().getSnapshot(getAdapterPosition()), getAdapterPosition());
                    }
                }
            });
        }
    }
}
