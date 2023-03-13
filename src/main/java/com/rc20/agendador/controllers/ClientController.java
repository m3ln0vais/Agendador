package com.rc20.agendador.controllers;

import com.rc20.agendador.enuns.Themes;
import com.rc20.agendador.models.Client;
import com.rc20.agendador.services.ClientService;
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
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String client(Model model, Optional<Long> id) {
        model.addAttribute("client", 
                id.isPresent() ? clientService.findById(id.get()).get() : new Client());
        model.addAttribute("themes", asList(Themes.values()));
        return "views/client";
    }

    @PostMapping
    public String register(Model model, @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("client", client);
            return "views/client";
        }
        
        Client save = clientService.save(client);

        return "redirect:/client?id=" + save.getId();
    }
}
