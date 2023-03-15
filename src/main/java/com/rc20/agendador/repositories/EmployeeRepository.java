package com.rc20.agendador.repositories;

import com.rc20.agendador.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Desenv. 02
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Page<Employee> findByNameContainingIgnoreCase(String name, Pageable page);

}
