package com.daw.atm.models.DTO;

public class Transfer {
    private String quantitat;
    private String numero;
    private String compteDesti;

    private String numeroTarjetaDestino;
    private int cantidad;

    public String getQuantitat() {
        return quantitat;
    }
    public void setQuantitat(String quantitat) {
        this.quantitat = quantitat;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getNumeroTarjetaDestino() {
        return numeroTarjetaDestino;
    }
    public void setNumeroTarjetaDestino(String numeroTarjetaDestino) {
        this.numeroTarjetaDestino = numeroTarjetaDestino;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getCompteDesti() {
        return compteDesti;
    }
    public void setCompteDesti(String compteDesti) {
        this.compteDesti = compteDesti;
    }



    
}
