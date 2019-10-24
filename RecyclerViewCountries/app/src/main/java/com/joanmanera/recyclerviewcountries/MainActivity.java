package com.joanmanera.recyclerviewcountries;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private Country[] paises;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountryParser countryParser = new CountryParser(this);
        countryParser.parse();
        paises = countryParser.getCountries();
        CountryAdapter countryAdapter = new CountryAdapter(this, paises);
        recyclerView = findViewById(R.id.rvPrincipal);
        recyclerView.setAdapter(countryAdapter);
    }
}
