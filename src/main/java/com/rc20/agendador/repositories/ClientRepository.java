package com.rc20.agendador.repositories;

import com.rc20.agendador.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Desenv. 02
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
