package com.daw.atm.models;

import java.time.LocalDate;
import java.time.Period;

public class Persona {

    // Atributs
    private String nom;
    private String cognoms;
    private String dni;
    private LocalDate dataNaixement;

    // Metodes

    public int edat() {
        return Period.between(dataNaixement, LocalDate.now()).getYears();
    }

    static public boolean validarDNI(String dni) {

        char[] lletres = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
                'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

        if (dni.length() != 9)
            return false;

        // dni: "11111111A"
        String numero = dni.substring(0, 8); // 11111111
        System.out.println(numero);

        try {
            int numInt = Integer.parseInt(numero);
            int index = numInt % 23;
            if (lletres[index] != Character.toUpperCase((dni.charAt(8))))
                return false;
            return true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error de conversió !!");
            return false;
        }

    }

    public Persona() {

    }

    @Override
    public String toString() {
        return "Persona [nom=" + nom + ", cognoms=" + cognoms + ", dni=" + dni + ", dataNaixement=" + dataNaixement
                + "]";
    }

    public Persona(String nom, String cognoms, String dni, LocalDate dataNaixement) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.dni = dni;
        this.dataNaixement = dataNaixement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void cantar() {
        System.out.println("Heiii!!!!!!!");
        System.out.println("lalalalalaalala  !!!!!!!");
        System.out.println("Em dic " + this.nom);
    }

    public LocalDate getdataNaixement() {
        return dataNaixement;
    }

    public void setAnyNaixement(LocalDate dataNaixement) {
        this.dataNaixement = dataNaixement;
    }
}