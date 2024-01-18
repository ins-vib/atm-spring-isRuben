package com.daw.atm.models;

import java.time.LocalDate;

public class Compte {
    
    // Atributs
    private String numero; // Numero de compte
    private double saldo; // Saldo de diners
    private LocalDate DataObertura; // Date obertura compte
    
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public LocalDate getDataObertura() {
        return DataObertura;
    }
    public void setDataObertura(LocalDate dataObertura) {
        DataObertura = dataObertura;
    }

    @Override
    public String toString() {
        return numero + " " + saldo + " " + DataObertura;
    }

    public Compte(String numero, double saldo, LocalDate dataObertura) {
        this.numero = numero;
        this.saldo = saldo;
        DataObertura = dataObertura;
    }

    public Compte() {
        this.saldo = 10;
    }

    public void ingresar(double quant) {
        this.saldo = this.saldo + quant;
    }

    public boolean retirar(double quant) {
        if(quant > saldo) {
            return false;
        } else {
            this.saldo = this.saldo - quant;
            return true;
        }
    }

    

    

    
}
