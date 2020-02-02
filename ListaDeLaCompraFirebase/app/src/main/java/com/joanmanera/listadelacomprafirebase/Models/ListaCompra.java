package com.joanmanera.listadelacomprafirebase.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ListaCompra implements Serializable {
    private String name;
    private long time;

    public ListaCompra(String name) {
        this.name = name;
        this.time = new Date().getTime();
    }
    public ListaCompra(){

    }

    public ListaCompra(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
