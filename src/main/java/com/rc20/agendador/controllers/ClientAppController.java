package com.rc20.agendador.controllers;

import com.rc20.agendador.models.Client;
import com.rc20.agendador.services.ClientService;
import jakarta.validation.Valid;
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
@RequestMapping("/client-app")
public class ClientAppController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clientForm")
    public String form(Model model, Optional<Long> id) {
        model.addAttribute("client", 
                id.isPresent() ? clientService.findById(id.get()).get() : new Client());
        return "views/clientApp/clientForm";
    }
    
    @PostMapping("/clientForm")
    public String register(Model model, @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {;
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("client", client);
            return "views/clientApp/clientForm";
        }
        
        clientService.save(client);
        return "redirect:/scheduling-app?id=" + client.getId();
    }
}
