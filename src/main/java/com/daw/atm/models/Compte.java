package com.daw.atm.models;

import java.time.LocalDate;

public class Compte {
    
    //atributs
    private String numero;
    private double saldo;
    private LocalDate DataObertura;
    private Persona propietari;

    static public String format ="ES1025";
    static public int comptador=0;


    public Persona getPropietari() {
        return propietari;
    }
    public void setPropietari(Persona propietari) {
        this.propietari = propietari;
    }
    
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
        return numero +" "+saldo+" "+ DataObertura+ " "+ propietari.getDni();
    }
    public Compte(double saldo, LocalDate dataObertura, Persona propietari) {
        comptador++;
        this.numero = format+String.format("%08d", comptador);
        this.saldo = saldo;
        DataObertura = dataObertura;
        this.propietari= propietari;
    }
    

    public void ingressar(double quantitat){
        this.saldo= this.saldo +quantitat;
    }
    public boolean retirar(double quantitat){
        if (quantitat>saldo) {
            return false;
        }
        else{
            this.saldo = this.saldo - quantitat;
            return true;
        }
    }
    
    
}