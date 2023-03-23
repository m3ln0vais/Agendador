package com.rc20.agendador.controllers;

import com.rc20.agendador.enuns.EmployeeStatus;
import com.rc20.agendador.models.Employee;
import com.rc20.agendador.services.EmployeeService;
import jakarta.validation.Valid;
import static java.util.Arrays.asList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Desenv. 02
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String employee(Model model, Optional<Integer> page, Optional<String> q) {
        model.addAttribute("page", q.isPresent()
                ? employeeService.findByName(page.orElse(0), q.orElse(""))
                : employeeService.find(page.orElse(0)));
        return "views/employee/employee";
    }

    @GetMapping("/form")
    public String employeeForm(Model model, Optional<Long> id) {
        model.addAttribute("employee",
                id.isPresent() ? employeeService.findById(id.get()).get() : new Employee());
        model.addAttribute("employeeStatus", asList(EmployeeStatus.values()));
        return "views/employee/employee-form";
    }

    @PostMapping
    public String register(Model model, @Valid Employee employee, BindingResult bindingResult   ) {
     
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("employee", employee);
            return "views/employee";
        }

        employeeService.save(employee);

        return "redirect:/employee";
    }
}
