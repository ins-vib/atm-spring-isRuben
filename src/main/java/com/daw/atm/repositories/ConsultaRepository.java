package com.daw.atm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw.atm.models.DTO.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    
}
