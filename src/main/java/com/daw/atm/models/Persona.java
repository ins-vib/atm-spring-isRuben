package com.daw.atm.models;

public class Persona {

    // Atributs
    private String nom;
    private String cognom;
    private String dni;
    private int edat;

    // Metodes

    public void parlar() {
        System.out.println("Hola!!!!!!");
        System.out.println("Estic Parlant!!!");
        System.out.println("Em dic " + this.nom);
    }

    @Override
    public String toString() {
        return "Persona [nom=" + nom + ", cognom=" + cognom + ", dni=" + dni + ", edat=" + edat + "]";
    }

    public Persona() {
        System.out.println("M'he creat.");
        edat = 18;
    }
    
    public Persona(String nom, String cognom, String dni) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
    }

    public void parlar(String idioma) {
        if(idioma.equals("cat")) {
            System.out.println("Hola!!!!!!");
            System.out.println("Estic Parlant!!!");
            System.out.println("Em dic " + this.nom);
        }

        if(idioma.equals("esp")) {
            System.out.println("Hola!!!!!!");
            System.out.println("Estoy Hablando!!!");
            System.out.println("Me llamo " + this.nom);
        }
    }

    public void cantar() {
        System.out.println("Hey!!!!!!");
        System.out.println("LALALALALALALALA!!!");
        System.out.println("Em dic " + this.nom);
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

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    

}
