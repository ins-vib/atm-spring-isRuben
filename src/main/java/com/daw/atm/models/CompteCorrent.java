package com.daw.atm.models;

import jakarta.persistence.Entity;

@Entity
public class CompteCorrent extends Compte{

    public CompteCorrent() {
        
    }
    public CompteCorrent(double saldo, Client propietari) {
        super(saldo, propietari);
    }

    @Override
    public String toString() {
        return "CompteCorrent " + this.numero + " te " + this.saldo + " euros";
    }
}
