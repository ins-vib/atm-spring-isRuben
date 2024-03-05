package com.daw.atm.models;

public class Diposit {
    private int valor;
    private int quantitat;
    
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getQuantitat() {
        return quantitat;
    }
    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }
    public Diposit(int valor, int quantitat) {
        this.valor = valor;
        this.quantitat = quantitat;
    }

    
}
