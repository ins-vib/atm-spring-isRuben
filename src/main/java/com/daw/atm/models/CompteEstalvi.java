package com.daw.atm.models;

import java.time.LocalDate;

public class CompteEstalvi extends Compte {
    static final double QUANTITAT_MINIMA = 1000;
    private double interes;

    public double getInteres() {
        return interes;
    }
    public void setInteres(double interes) {
        this.interes = interes;
    }

    public CompteEstalvi() {
        
    }
    public CompteEstalvi(double saldo, LocalDate dataObertura, Persona propietari, double interes) {
        super(saldo, dataObertura, propietari);
        this.interes = interes;
    }
    public CompteEstalvi(double interes) {
        this.interes = interes;
    }

}

