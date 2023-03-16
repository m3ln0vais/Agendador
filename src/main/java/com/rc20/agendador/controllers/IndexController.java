package com.rc20.agendador.controllers;

import com.rc20.agendador.models.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Desenv. 02
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "views/login";
    }
    
    @PostMapping("/")
    public String login(Client client){
        if(client.getPerson().getContact().getEmail().equals("admin") && 
           client.getPassword().equals("admin")){
            return "redirect: views/main";
        }else {
            return "redirect: views/login";
        }
    }
    
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
}
