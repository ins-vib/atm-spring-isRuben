package com.daw.atm.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Operacio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codi;
    
    public Long getCodi() {
        return codi;
    }
    public void setCodi(Long codi) {
        this.codi = codi;
    }
    public Compte getCompte() {
        return compte;
    }
    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    LocalDateTime data;
    String descripcio;

    @ManyToOne
    private Compte compte;


    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public String getDescripcio() {
        return descripcio;
    }
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    public Operacio() {
        data = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "Operacio [data = " + data + ","+"descripcio = "+descripcio+"]";
    }   
}