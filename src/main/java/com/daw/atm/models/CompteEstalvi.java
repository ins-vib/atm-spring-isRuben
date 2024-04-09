package com.daw.atm.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class CompteEstalvi extends Compte {
    static final public double QUANTITAT_MINIMA = 1000;
    private double interes;

    @Override
    public String toString() {
        return "CompteEstalvi " +this.numero+ " te " + this.saldo + " euros";
    }

    public double getInteres() {
        return interes;
    }
    public void setInteres(double interes) {
        this.interes = interes;
    }

    public CompteEstalvi() {
        
    }
    public CompteEstalvi(double saldo, Client propietari, double interes) {
        super(saldo, propietari);
        this.interes = interes;
    }
    public CompteEstalvi(double interes) {
        this.interes = interes;
    }

    @Override
    public boolean retirar(double quantitat) {
        if(this.saldo - quantitat < CompteEstalvi.QUANTITAT_MINIMA) return false;
        return super.retirar(quantitat);
    }

    public double aplicarInteres() {
        this.saldo += this.saldo * this.interes;
        return this.saldo;
    }

}

