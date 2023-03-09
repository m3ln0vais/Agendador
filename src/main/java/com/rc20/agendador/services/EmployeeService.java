package com.rc20.agendador.services;

import com.rc20.agendador.models.Employee;
import com.rc20.agendador.repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Desenv. 02
 */

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    
    public List<Employee> find(){
        return employeeRepository.findAll();
    }
    
    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }
    
    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

//    public void findByLogin(String user, String pass) {
//        employeeRepository.findBy
//    }
}
