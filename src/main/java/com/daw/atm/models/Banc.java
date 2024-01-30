package com.daw.atm.models;

public class Banc {
    

    private String nom;
    private int numero_banc;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getNumero_banc() {
        return numero_banc;
    }
    public void setNumero_banc(int numero_banc) {
        this.numero_banc = numero_banc;
    }
    public Banc(String nom, int numero_banc) {
        this.nom = nom;
        this.numero_banc = numero_banc;
    }
    @Override
    public String toString() {
        return "Banc [nom=" + nom + ", numero_banc=" + numero_banc + "]";
    }

    
}