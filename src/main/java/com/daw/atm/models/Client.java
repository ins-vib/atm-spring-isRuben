package com.daw.atm.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Client extends Persona {
    
    private String email;

    @OneToMany(mappedBy = "propietari")
    List<Compte> comptes= new ArrayList<Compte>();

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

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