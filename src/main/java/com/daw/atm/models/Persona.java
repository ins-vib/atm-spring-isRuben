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

}
