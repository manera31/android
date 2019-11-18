package com.joanmanera.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AdapterStars extends RecyclerView.Adapter<AdapterStars.StarViewHolder> implements View.OnClickListener {
    private Star[] stars;
    private Context context;
    private View.OnClickListener listener;

    public AdapterStars(Context context, Star[] stars) {
        this.context = context;
        this.stars = stars;
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_star, parent, false);
        itemView.setOnClickListener(this);
        StarViewHolder viewHolder = new StarViewHolder(itemView, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        Star star = stars[position];
        holder.bindStar(star);
    }

    @Override
    public int getItemCount() {
        return stars.length;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null) {
            listener.onClick(v);
        }
    }


    public static class StarViewHolder extends RecyclerView.ViewHolder{

        private TextView tvID;
        private TextView tvProper;
        private TextView tvDist;
        private TextView tvMag;
        private TextView tvSpect;
        private Context context;

        public StarViewHolder(View itemView, Context context){
            super(itemView);
            this.context = context;

            tvID = itemView.findViewById(R.id.tvID);
            tvProper = itemView.findViewById(R.id.tvProper);
            tvDist = itemView.findViewById(R.id.tvDist);
            tvMag = itemView.findViewById(R.id.tvMag);
            tvSpect = itemView.findViewById(R.id.tvSpect);
        }

        public void bindStar(Star star){
            tvID.setText(star.getId());
            tvProper.setText(star.getProper());
            tvDist.setText((int) star.getDist());
            tvMag.setText((int) star.getMag());
            tvSpect.setText(star.getSpect());
        }
    }
}
