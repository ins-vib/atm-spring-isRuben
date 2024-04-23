package com.daw.atm.models.DTO;

public class Credencials {
    private String number;
    private String PIN;
    private String nouPin;

    public String getNouPin() {
        return nouPin;
    }
    public void setNouPin(String nouPin) {
        this.nouPin = nouPin;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getPIN() {
        return PIN;
    }
    public void setPIN(String pIN) {
        PIN = pIN;
    }
    @Override
    public String toString() {
        return "Credencials [number=" + number + ", PIN=" + PIN + "]";
    }
}