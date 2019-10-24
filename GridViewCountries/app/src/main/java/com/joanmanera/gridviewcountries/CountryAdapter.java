package com.joanmanera.gridviewcountries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class CountryAdapter extends ArrayAdapter {

    private Country[] datos;

    public CountryAdapter(Context context, Country[] countries){
        super(context,R.layout.gridviewitem_country, countries);
        this.datos = countries;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        ViewHolder viewHolder;

        if(item == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.gridviewitem_country, null);

            viewHolder = new ViewHolder();
            viewHolder.pais = item.findViewById(R.id.tvPais);
            viewHolder.capital = item.findViewById(R.id.tvCapital);
            viewHolder.poblacion = item.findViewById(R.id.tvPoblacion);
            viewHolder.imagen = item.findViewById(R.id.ivImagen);

            item.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)item.getTag();
        }


        viewHolder.pais.setText(datos[position].getCiudad());
        viewHolder.capital.setText(datos[position].getCapital());
        viewHolder.poblacion.setText(String.valueOf(datos[position].getPoblacion()));

        int id = this.getContext().getResources().getIdentifier("_"+ datos[position].getCountryCode().toLowerCase(), "drawable", this.getContext().getPackageName());

        viewHolder.imagen.setImageResource(id);

        return item;
    }

    static class ViewHolder {
        TextView pais;
        TextView capital;
        TextView poblacion;
        ImageView imagen;
    }
}
