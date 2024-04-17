package com.daw.atm.models.DTO;

public class Credencials {
    private String number;
    private String PIN;
    private String nuevoPIN;

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getPIN() {
        return PIN;
    }

    @Override
    public String toString() {
        return "Credencials [number=" + number + ", PIN=" + PIN + "]";
    }

    public void setPIN(String pIN) {
        PIN = pIN;
    }

    public String getNuevoPIN() {
        return nuevoPIN;
    }
    
    public void setNuevoPIN(String nuevoPIN) {
        this.nuevoPIN = nuevoPIN;
    }
}
