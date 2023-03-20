package com.rc20.agendador.services;

import com.rc20.agendador.models.Employee;
import com.rc20.agendador.repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author Desenv. 02
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        System.out.println(employee);
        return employeeRepository.save(employee);
    }

    public List<Employee> find() {
        return employeeRepository.findAll();
    }

    public Page<Employee> find(Integer page) {
        page = Optional.ofNullable(page).orElse(0);
        page = page < 0 ? 0 : page;
        return employeeRepository.findAll(PageRequest.of(page, 5));
    }

    public Page<Employee> findByName(Integer page, String name) {
       return null;
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

//    public void findByLogin(String user, String pass) {
//        employeeRepository.findBy
//    }
}
