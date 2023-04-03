package com.rc20.agendador.controllers;

import com.rc20.agendador.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Desenv. 02
 */

@Controller
@RequestMapping("/client-app")
public class ClientAppController {
    @Autowired
    private ClientService clientService;
    
    @GetMapping("/historic")
    public String historic(){
        return "views/clientApp/historic";
    }
    
}
