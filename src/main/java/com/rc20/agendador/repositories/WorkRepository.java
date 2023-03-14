package com.rc20.agendador.repositories;

import com.rc20.agendador.models.Work;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Desenv. 02
 */

@Repository
public interface WorkRepository extends JpaRepository<Work, Long>{
    public Page<Work> findByNameContainingIgnoreCase(String name, Pageable page);
    
}
