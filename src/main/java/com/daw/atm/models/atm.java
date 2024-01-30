package com.daw.atm.models;

public class atm {
    
    private String codi;
    private String adreça;
    private String estat;


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
    public atm(String codi, String adreça, String estat) {
        this.codi = codi;
        this.adreça = adreça;
        this.estat = estat;
    }
    @Override
    public String toString() {
        return "ATM [codi=" + codi + ", adreça=" + adreça + ", estat=" + estat + "]";
    }

    
    
    
}