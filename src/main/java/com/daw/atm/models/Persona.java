package com.daw.atm.models;

public class Persona {

    // Atributs
    public String nom;
    public String cognom;
    public String dni;

    // Metodes
    public void parlar() {
        System.out.println("Hola!!!!!!");
        System.out.println("Estic Parlant!!!");
        System.out.println("Em dic " + this.nom);
    }

}
