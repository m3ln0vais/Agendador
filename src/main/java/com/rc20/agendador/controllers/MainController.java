package com.rc20.agendador.controllers;

import com.rc20.agendador.services.ClientService;
import com.rc20.agendador.services.StoreService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/main")
    public String main(Model model, Long id) throws IOException {
        model.addAttribute("store", storeService.findById(id).get());
        return "views/main";
    }

    @GetMapping("/mainClient")
    public String mainClient(Model model, Long id) throws IOException{
        model.addAttribute("client", clientService.findById(id).get().getId());
        return "views/clientApp/mainClient";
    }
}
