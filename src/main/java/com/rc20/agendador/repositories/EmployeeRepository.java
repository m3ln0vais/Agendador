package com.rc20.agendador.repositories;

import com.rc20.agendador.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Desenv. 02
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select * from employee where password = :password", nativeQuery = true)
    public Employee login(String password);
}
