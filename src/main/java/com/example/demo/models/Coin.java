package com.example.demo.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private long id;
    private String nombre;
    private String ticker;
    private double factorConversion;


    public Coin() {
    }

    public Coin(String nombre, String ticker, double factorConversion) {
        this.nombre = nombre;
        this.ticker = ticker;
        this.factorConversion = factorConversion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getFactorConversion() {
        return factorConversion;
    }

    public void setFactorConversion(double factorConversion) {
        this.factorConversion = factorConversion;
    }
}
