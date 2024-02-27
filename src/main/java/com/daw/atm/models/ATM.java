package com.daw.atm.models;

public class ATM {
    
    private String codi;
    private String adreça;
    private String estat;

    private Banc banc;
    private Targeta targetaActual;

    private Diposit llistaDiposit[];

    public boolean assignarTargeta(String numero, int PIN) {
        
        Targeta t = banc.getTargeta(numero);
        if(t==null) return false;
        if(t.validarPin(PIN)==false) return false;
        this.targetaActual = t;
        return true;
        
    }

    public void ingressar (double quantitat) {
        if(this.targetaActual != null) {
            this.targetaActual.getCompteCorrent().ingressar(quantitat);
        }
        for (int i = 0; i < llistaDiposit.length; i++) {
            double valor = quantitat/llistaDiposit[i].getValor();
            double quant = llistaDiposit[i].getQuantitat() + valor;
            llistaDiposit[i].setQuantitat(quant);
            valor = quantitat%llistaDiposit[i].getValor();
        }
    }


    public void tancar(){
        this.estat="tancat";
    }

    public void obrir(){
        this.estat = "obert";
    }


    public String getCodi() {
        return codi;
    }
    public void setCodi(String codi) {
        this.codi = codi;
    }
    public String getAdreça() {
        return adreça;
    }
    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }
    public String getEstat() {
        return estat;
    }
    public void setEstat(String estat) {
        this.estat = estat;
    }
    public ATM(String codi, String adreça, String estat) {
        this.codi = codi;
        this.adreça = adreça;
        this.estat = estat;
        this.banc = new Banc();
    }
    @Override
    public String toString() {
        return "ATM [codi=" + codi + ", adreça=" + adreça + ", estat=" + estat + "]";
    }

    public ATM() {
        llistaDiposit = new Diposit[4];
        llistaDiposit[0] = new Diposit(5, 100);
        llistaDiposit[1] = new Diposit(10, 50);
        llistaDiposit[2] = new Diposit(20, 80);
        llistaDiposit[3] = new Diposit(50, 75);
    }
    
    
}