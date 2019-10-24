package com.joanmanera.recyclerviewcountries;

public class Country {
    private String ciudad;
    private String capital;
    private long poblacion;
    private String countryCode;

    public Country(String ciudad, String capital, long poblacion, String countryCode) {
        this.ciudad = ciudad;
        this.capital = capital;
        this.poblacion = poblacion;
        this.countryCode = countryCode;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(long poblacion) {
        this.poblacion = poblacion;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


}
