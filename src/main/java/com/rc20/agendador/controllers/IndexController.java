package com.rc20.agendador.controllers;

import com.rc20.agendador.dto.LoginDTO;
import com.rc20.agendador.models.Employee;
import com.rc20.agendador.models.Store;
import com.rc20.agendador.services.EmployeeService;
import com.rc20.agendador.services.StoreService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Desenv. 02
 */
@Controller
public class IndexController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/")
    public String index() {
        return "views/login";
    }

    @GetMapping("/main")
    public String main(Model model, @RequestParam Long id) {
        model.addAttribute("store", storeService.findById(id).get());
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
