package com.daw.atm.models;

import java.time.LocalDate;

public class Banc {
    private String nom;
    private int numBanc;

    private Client[] llistaClients;
    private Compte[] llistaComptes;
    private Targeta[] llistaTargetes;

    public Targeta getTargeta(String numero) {
        
        for (Targeta t : llistaTargetes) {
            if (t.getNumero().equals(numero)) return t; 
            
        }
        
        return null;
    }




    public Banc(){
        llistaClients = new Client[6];
            llistaClients[0] = new Client("Ana", "Ponts", "12345678A",LocalDate.parse("2002-08-09"),"aponts@prova.com");
            llistaClients[1] = new Client("India", "Ulises", "23456789B",LocalDate.parse("2000-01-09"),"iulises@prova.com");
            llistaClients[2] = new Client("Miquel", "Ponts", "34567890D",LocalDate.parse("2002-08-09"),"mponts@prova.com");
            llistaClients[3] = new Client("Maia", "Iglesias", "45678901E",LocalDate.parse("2002-08-09"),"miglesias@prova.com");
            llistaClients[4] = new Client("Nil", "Iglesias", "45678901E",LocalDate.parse("2002-08-09"),"niglesias@prova.com");
            llistaClients[5] = new Client("Francesc", "Iglesias", "45678901V",LocalDate.parse("2002-08-09"),"francesciglesias@prova.com");
        
        llistaComptes = new Compte[12];
            llistaComptes[0]= new CompteCorrent(1000.0, llistaClients[0]);
            llistaComptes[1]= new CompteCorrent(1000.0, llistaClients[1]);
            llistaComptes[2]= new CompteCorrent(1000.0, llistaClients[2]);
            llistaComptes[3]= new CompteCorrent(1000.0, llistaClients[3]);
            llistaComptes[4]= new CompteCorrent(1000.0, llistaClients[4]);
            llistaComptes[5]= new CompteCorrent(1000.0, llistaClients[5]);

            llistaComptes[6]= new CompteEstalvi(1000.0, llistaClients[0],2);
            llistaComptes[7]= new CompteEstalvi(1000.0, llistaClients[1],2);
            llistaComptes[8]= new CompteEstalvi(1000.0, llistaClients[2],2);
            llistaComptes[9]= new CompteEstalvi(1000.0, llistaClients[3],2);
            llistaComptes[10]= new CompteEstalvi(1000.0, llistaClients[4],2);
            llistaComptes[11]= new CompteEstalvi(1000.0, llistaClients[5],2);

        llistaTargetes = new Targeta[6];
            llistaTargetes[0]= new Targeta("11112222333A", LocalDate.parse("2026-01-01"), 230, 1234, (CompteCorrent)llistaComptes[0]);
            llistaTargetes[1]= new Targeta("11112222333B", LocalDate.parse("2026-01-01"), 230, 1234, (CompteCorrent)llistaComptes[1]);
            llistaTargetes[2]= new Targeta("11112222333C", LocalDate.parse("2026-01-01"), 230, 1234, (CompteCorrent)llistaComptes[2]);
            llistaTargetes[3]= new Targeta("11112222333F", LocalDate.parse("2026-01-01"), 230, 1234, (CompteCorrent)llistaComptes[3]);
            llistaTargetes[4]= new Targeta("11112222333E", LocalDate.parse("2026-01-01"), 230, 1234, (CompteCorrent)llistaComptes[4]);
            llistaTargetes[5]= new Targeta("11112222333D", LocalDate.parse("2026-01-01"), 230, 1234, (CompteCorrent)llistaComptes[5]);
    }
            
      
    public Client[] getLlistaClients() {
        return llistaClients;
    }

    public Compte[] getLlistaComptes() {
        return llistaComptes;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getNumBanc() {
        return numBanc;
    }
    public void setNumBanc(int numBanc) {
        this.numBanc = numBanc;
    }
    public Banc(String nom, int numBanc) {
        this.nom = nom;
        this.numBanc = numBanc;
    }
    @Override
    public String toString() {
        return "Banc [nom=" + nom + ", numBanc=" + numBanc + "]";
    }


    public Targeta[] getLlistaTargetes() {
        return llistaTargetes;
    }

    public Compte getCompte (String numero) {
        for(Compte compte: llistaComptes) {
            if(compte.getNumero().equals(numero)) return compte;
        }
        return null;
    }


    
}