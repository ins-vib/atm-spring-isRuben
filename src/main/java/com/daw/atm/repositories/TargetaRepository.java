
package com.daw.atm.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.daw.atm.models.Targeta;
import com.daw.atm.repositories.TargetaRepository;

@Repository
public interface TargetaRepository extends JpaRepository<Targeta,String> {

    
}
