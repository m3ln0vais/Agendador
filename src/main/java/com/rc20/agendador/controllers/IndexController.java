package com.rc20.agendador.controllers;

import com.rc20.agendador.models.Employee;
import com.rc20.agendador.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Desenv. 02
 */
@Controller
public class IndexController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String index() {
        return "views/login";
    }

    @PostMapping("/")
    public String login(Model model, Employee employee) {
        Employee e = this.employeeRepository.login(employee.getPassword());
        if (e != null) {
            return "redirect: views/main";
        } else {
            model.addAttribute("error", "senha inválida");
            return "redirect: views/login";
        }
    }

//    @PostMapping("/")
//    public String login(Client client){
//        if(client.getPerson().getContact().getEmail().equals("admin") && 
//           client.getPassword().equals("admin")){
//            return "redirect: views/main";
//        }else {
//            return "redirect: views/login";
//        }
//    }
    @GetMapping("/main")
    public String main() {
        return "views/main";
    }

    @GetMapping("/schedule")
    public String schedule() {
        return "views/schedule";
    }

    @GetMapping("/service")
    public String service() {
        return "views/service";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "views/dashboard";
    }
}
