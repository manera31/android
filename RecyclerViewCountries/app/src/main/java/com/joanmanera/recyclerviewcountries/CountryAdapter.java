package com.joanmanera.recyclerviewcountries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>
        implements View.OnClickListener {

    private Country[] countries;
    private Context context;
    private View.OnClickListener listener;

    public CountryAdapter(Context context, Country[] countries) {
        this.context = context;
        this.countries = countries;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_country_constraint, parent, false);

        itemView.setOnClickListener(this);

        CountryViewHolder viewHolder = new CountryViewHolder(itemView,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        Country country = countries[position];
        holder.bindCountry(country);
    }

    @Override
    public int getItemCount() {
        return countries.length;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null) {
            listener.onClick(view);
        }
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivFlag;
        private TextView tvCountryName;
        private TextView tvCountryCapital;
        private TextView tvCountryPopulation;
        private Context context;

        public CountryViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            ivFlag = (ImageView) itemView.findViewById(R.id.ivImagen);
            tvCountryName = (TextView) itemView.findViewById(R.id.tvPais);
            tvCountryCapital = (TextView) itemView.findViewById(R.id.tvCapital);
            tvCountryPopulation = (TextView) itemView.findViewById(R.id.tvPoblacion);
        }

        public void bindCountry(Country country) {
            /**
             * Intentamos obtener el ID del drawable asociado a la imagen a partir del códgio ISO
             * del país de 2 caracteres. En caso de que no exista una imagen para la bandera de dicho
             * país, se dejará el valor por defecto que tiene en el Layout.
             */
            try {
                /**
                 * Obtenemos el código de 2 caracteres del país y nos aseguramos que esté en minúsculas
                 * ya que las imágenes situadas en /res/drawable están en minúsculas.
                 * Además le añadimos el caracter "_" delante para que coincida con el nombre de los Drawables.
                 */
                String flagName = "_"+country.getCountryCode().toLowerCase();
                /** Obtenemos el ID del drawable (imagen de la bandera) a partir del flagName */
                int resID = context.getResources().getIdentifier(flagName, "drawable", context.getPackageName());
                /** Si hemos conseguido obtener el ID del drawable asociado, se lo asignamos al ImageView */
                if(resID != 0) {
                    ivFlag.setImageResource(resID);
                } else {
                    flagName = "_onu";
                    resID = context.getResources().getIdentifier(flagName, "drawable", context.getPackageName());
                    ivFlag.setImageResource(resID);
                }

            } catch (Exception e) {
                /**
                 * Si falla la obtención del ID del drawable no hacemos nada. Simplemente se quedará
                 * con la imagen de la bandera que tenga asignada por defecto.
                 */
            }

            /** Asignamos el nombre del país */
            tvCountryName.setText(country.getCapital());

            /** Asignamos el nombre de la capital */
            tvCountryCapital.setText(country.getCapital());

            /** Asignamos el número de habitantes */
            tvCountryPopulation.setText(String.valueOf(country.getPoblacion()));
        }
    }
}

