package com.daw.atm.models;

public class banc {
    private String nom;
    private int numerobancari;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getNumerobancari() {
        return numerobancari;
    }
    public void setNumerobancari(int numerobancari) {
        this.numerobancari = numerobancari;
    }
    public banc(String nom, int numerobancari) {
        this.nom = nom;
        this.numerobancari = numerobancari;
    }
    
    @Override
    public String toString() {
        return "banc [nom=" + nom + ", numerobancari=" + numerobancari + "]";
    }
}



