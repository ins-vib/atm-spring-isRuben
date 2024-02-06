package com.daw.atm.models;

import java.time.LocalDate;

public class Empleat  extends Persona {
    
    private String categoria;
    private double sou;
    private String nom;


    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public double getSou() {
        return sou;
    }
    public void setSou(double sou) {
        this.sou = sou;
    }
    public Empleat(String nom, String cognoms, String dni, LocalDate dataNaixement, String categoria, double sou) {
        super(nom, cognoms, dni, dataNaixement);
        this.categoria = categoria;
        this.sou = sou;
        super.nom="ee";
    }
    public Empleat(String categoria, double sou) {
        this.categoria = categoria;
        this.sou = sou;
    }

    public Empleat(){
        
    }

    
}