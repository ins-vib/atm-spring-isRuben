package com.daw.atm.models;

import java.time.LocalDate;
import java.time.Period;

public class Persona {

    // Atributs
    private String nom;
    private String cognom;
    private String dni;
    private LocalDate dataNaixemenet;

    // Metodes

    public int edat() {

        return Period.between(dataNaixemenet, LocalDate.now()).getYears();
    }

    static public boolean validarDNI (String dni) {
        return true;
    }

    
    public Persona() {
        
    }

    @Override
    public String toString() {
        return "Persona [nom=" + nom + ", cognom=" + cognom + ", dni=" + dni + "]";
    }

    
    public Persona(String nom, String cognom, String dni, LocalDate dataNaixemenet) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.dataNaixemenet = dataNaixemenet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getDataNaixemenet() {
        return dataNaixemenet;
    }

    public void setDataNaixemenet(LocalDate dataNaixemenet) {
        this.dataNaixemenet = dataNaixemenet;
    }
    

}
