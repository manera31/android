package com.joanmanera.gridviewcountries;

import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by ggascon on 22/10/15.
 */
public class CountryParser {

    /** Array que contendrá los objetos Country */
    private Country[] countries;
    /** InputStream para poder leer del archivo countries.xml */
    private InputStream countriesFile;

    /** Al constructor le pasamos el contexto para que pueda tener acceso a los recursos de la aplicación */
    public CountryParser(Context c) {
        /** Obtenemos una referencia al archivo /res/raw/countries.xml */
        this.countriesFile = c.getResources().openRawResource(R.raw.countries);
    }

    /**
     * Obtiene los datos de los países desde un archivo xml mediante DOM,
     * y los carga en el array countries.
     * @return boolean Devuelve verdadero si ha ido bien. False en caso contrario.
     */
    public boolean parse() {
        /** Parsed controla si se han podido parsear los datos. Inicialmente a false */
        boolean parsed = false;
        /** Inicializamos a null el array de países */
        countries = null;
        try {
            /** Obtenemos una referencia al DocumentBuilderFactory necesaria para parsear mediante DOM */
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            /** Obtenemos una referencia al DocumentBuilder necesaria para parsear mediante DOM */
            DocumentBuilder builder = factory.newDocumentBuilder();
            /** Obtenemos una referencia al Document parseando mediante DOM */
            Document dom = builder.parse(countriesFile);
            /** Obtenemos el elemento raíz del documento */
            Element root = dom.getDocumentElement();
            /** Obtenemos la lista de nodos con el tag "country" */
            NodeList items = root.getElementsByTagName("country");
            /** Inicializamos el array de countries con tamaño igual al número de nodos de tipo country */
            countries = new Country[items.getLength()];
            /** Recorremos cada uno de los nodos */
            for (int i = 0; i < items.getLength(); i++) {
                /** Obtenemos el nodo de la posición i */
                Node item = items.item(i);
                /** Obtenemos los atributos necesarios para construir cada objeto Country */
                String countryCode = item.getAttributes().getNamedItem("countryCode").getNodeValue();
                String countryName = item.getAttributes().getNamedItem("countryName").getNodeValue();
                String countryCapital = item.getAttributes().getNamedItem("capital").getNodeValue();
                long countryPopulation = Long.valueOf(item.getAttributes().getNamedItem("population").getNodeValue());
                String countryIso3 = item.getAttributes().getNamedItem("isoAlpha3").getNodeValue();
                /** Con los datos obtenidos, creamos el objeto Country en la posición i del array */
                countries[i] = new Country(countryName, countryCapital, countryPopulation, countryCode);
            }
            /** Si hemos llegado hasta aquí, podemos asegurar que el documento xml ha sido parseado correctamente */
            parsed = true;
        } catch (ParserConfigurationException pce) {
            Log.e("CountryParser", "ParserConfigurationException: "+pce.getLocalizedMessage());
        } catch (Exception e) {
            Log.e("CountryParser", "Unknown Exception: "+e.getLocalizedMessage());
        }
        return parsed;
    }

    /**
     * Devuelve la lista de países
     * @return Country[]
     */
    public Country[] getCountries() {
        return this.countries;
    }
}
