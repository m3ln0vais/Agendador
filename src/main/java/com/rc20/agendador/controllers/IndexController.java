package com.rc20.agendador.controllers;

import com.rc20.agendador.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/store")
    public String main(Model model, @RequestParam Long id) {
        model.addAttribute("store", storeService.findById(id).get());
        return "views/store/store";
    }

    @GetMapping("/service")
    public String service() {
        return "views/service";
    }
}
