package com.rc20.agendador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    
    @GetMapping("/main")
    public String main() {
        return "views/main";
    }
    
    @GetMapping("/service")
    public String service() {
        return "views/service";
    }
}
