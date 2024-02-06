package com.daw.atm.models;

public class Targeta {
    
    protected String numero;
    protected String dataVenciment;
    protected int cw;
    protected String pin;
    protected boolean activa;
    protected boolean bloquejada;
    protected int numIntentos;
    protected int maxIntentos;

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getDataVenciment() {
        return dataVenciment;
    }
    public void setDataVenciment(String dataVenciment) {
        this.dataVenciment = dataVenciment;
    }
    public int getCw() {
        return cw;
    }
    public void setCw(int cw) {
        this.cw = cw;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
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
    public int getNumIntentos() {
        return numIntentos;
    }
    public void setNumIntentos(int numIntentos) {
        this.numIntentos = numIntentos;
    }
    public int getINTENTOS_MAX() {
        return INTENTOS_MAX;
    }

    

    
}
