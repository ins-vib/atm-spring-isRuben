package com.daw.atm.models;

import java.time.LocalDate;
import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity 
public class Targeta {
    public static int MAX_INTENTS = 3;
    @Id
    protected String numero;
    protected LocalDate dataCaducitat;
    protected int cvv;
    protected int pin;
    protected boolean activa;
    protected boolean bloquejada;
    protected int numIntents;

    @ManyToOne
    private CompteCorrent compteCorrent;

    public CompteCorrent getCompteCorrent() {
        return compteCorrent;
    }

    public boolean validarPin(String string) {
        
        if (this.bloquejada) return false;
        if(string==this.pin){
            this.numIntents=0;
         return true; 
        }
        this.numIntents++;
        if (this.numIntents==MAX_INTENTS) this.bloquejada = true;
            return false;
        }

        public boolean validarPin2(int string) {
        
        if (this.bloquejada) return false;
        if(string==this.pin){
            this.numIntents=0;
         return true; 
        }
        this.numIntents++;
        if (this.numIntents==MAX_INTENTS) this.bloquejada = true;
            return false;
        }
        
        
    


    @Override
    public String toString() {
        return "Targeta [numero=" + numero + ", dataCaducitat=" + dataCaducitat + ", cvv=" + cvv + ", pin=" + pin
                + ", activada=" + activa + ", bloquejada=" + bloquejada + ", numIntents=" + numIntents + "]";
    }
    public Targeta(){
        
    }
    public Targeta(String numero, LocalDate dataCaducitat, int cvv, int pin,CompteCorrent compteCorrent) {
        this.numero = numero;
        this.dataCaducitat = dataCaducitat;
        this.cvv = cvv;
        this.pin = pin;
        this.activa = true;
        this.bloquejada = false;
        this.numIntents = 0;
        this.compteCorrent = compteCorrent;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }
    public void setDataCaducitat(LocalDate dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }
    public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public boolean isActiva() {
        return activa;
    }
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    public boolean isBloquejada() {
        return bloquejada;
    }
    public void setBloquejada(boolean bloquejada) {
        this.bloquejada = bloquejada;
    }
    public int getNumIntents() {
        return numIntents;
    }
    public void setNumIntents(int numIntents) {
        this.numIntents = numIntents;
    }



}