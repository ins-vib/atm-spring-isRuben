package com.daw.atm.models.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomUsuari;
    private String cognomUsuari;
    private String email;
    private String consulta;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNomUsuari() {
        return nomUsuari;
    }
    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }
    public String getCognomUsuari() {
        return cognomUsuari;
    }
    public void setCognomUsuari(String cognomUsuari) {
        this.cognomUsuari = cognomUsuari;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getConsulta() {
        return consulta;
    }
    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }
}

    