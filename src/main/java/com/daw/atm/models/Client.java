package com.daw.atm.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Client extends Persona {
    
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client(String nom, String cognoms, String dni, LocalDate dataNaixement, String email) {
        super(nom, cognoms, dni, dataNaixement);
        this.email = email;
    }

    public Client(String email) {
        this.email = email;
    }

    public Client(){
        
    }

    @Override
    public String toString() {
        return "Clients [email=" + email + "]"+super.toString();
    }

    
}