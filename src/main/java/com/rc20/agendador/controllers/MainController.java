package com.rc20.agendador.controllers;

import com.rc20.agendador.models.Client;
import com.rc20.agendador.models.Employee;
import com.rc20.agendador.models.Work;
import com.rc20.agendador.services.ClientService;
import com.rc20.agendador.services.EmployeeService;
import com.rc20.agendador.services.StoreService;
import com.rc20.agendador.services.WorkService;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Desenv. 02
 */
@Controller
public class MainController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private WorkService workService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/main")
    public String main(Model model, Long id) throws IOException {
        model.addAttribute("store", storeService.findById(id).get());
        return "views/main";
    }

    @GetMapping("/mainClient")
    public String mainClient(Model model, Long id) throws IOException {
        model.addAttribute("client", clientService.findById(id).get());

        List<Work> listWork = workService.find();
        model.addAttribute("listWork", listWork);
        model.addAttribute("work", new Work());

        List<Employee> listEmployee = employeeService.find();
        model.addAttribute("listEmployee", listEmployee);
        model.addAttribute("employee", new Employee());
        return "views/clientApp/mainClient";
    }

    @PostMapping("/mainClient")
    public String register(Model model, Client client, Long id) {

        clientService.save(client);
        return "views/clientApp/mainClient";
    }

}
