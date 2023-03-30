package com.rc20.agendador.controllers;

import com.rc20.agendador.models.Store;
import com.rc20.agendador.services.StoreService;
import java.util.Optional;
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

    @GetMapping("/main")
    public String main(Model model, Optional<Long> id) {
        model.addAttribute("store", storeService.findById(id.get()).get());

        return "views/main";
    }
}
