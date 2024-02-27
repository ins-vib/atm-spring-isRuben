package com.daw.atm.models;

public class Diposit {
    private double valor;
    private double quantitat;
    
    public double getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public double getQuantitat() {
        return quantitat;
    }
    public void setQuantitat(double quantitat) {
        this.quantitat = quantitat;
    }
    public Diposit(double valor, double quantitat) {
        this.valor = valor;
        this.quantitat = quantitat;
    }

    
}
