package com.daw.atm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw.atm.models.Operacio;

@Repository
public interface OperacioRepository extends JpaRepository<Operacio,Long> {

}