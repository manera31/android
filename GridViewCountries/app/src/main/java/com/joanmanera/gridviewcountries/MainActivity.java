package com.joanmanera.gridviewcountries;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Country[] paises;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountryParser countryParser = new CountryParser(this);
        countryParser.parse();
        paises = countryParser.getCountries();
        CountryAdapter countryAdapter = new CountryAdapter(this, paises);
        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(countryAdapter);
    }
}
