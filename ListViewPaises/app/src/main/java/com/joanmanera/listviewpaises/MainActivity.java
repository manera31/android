package com.joanmanera.listviewpaises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private Country[] paises;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountryParser countryParser = new CountryParser(this);
        countryParser.parse();
        paises = countryParser.getCountries();
        CountryAdapter countryAdapter = new CountryAdapter(this, paises);
        listView = findViewById(R.id.lvPaises);
        listView.setAdapter(countryAdapter);
    }
}
