package com.daw.atm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.atm.models.Compte;


public interface CompteCor extends JpaRepository<Compte,String> {
    Optional<Compte> findByNumero(String numero);
}
