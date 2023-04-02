package com.rc20.agendador.controllers;

import com.rc20.agendador.dto.RegisterDTO;
import com.rc20.agendador.enuns.Themes;
import com.rc20.agendador.models.Store;
import com.rc20.agendador.services.StoreService;
import jakarta.validation.Valid;
import static java.util.Arrays.asList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    
    @GetMapping("/loginClient")
    public String loginClient() {
        return "views/clientApp/loginClient";
    }
    
    @GetMapping("/mainClient")
    public String mainClient() {
        return "views/clientApp/mainClient";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("themes", asList(Themes.values()));
        model.addAttribute("register", new RegisterDTO());
        return "views/register";
    }

    @PostMapping("/register")
    public String registerForm(Model model, @Valid RegisterDTO rdto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("register", rdto);
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("themes", asList(Themes.values()));
            return "views/register";
        }
        
        Store store = new Store();
        store.setName(rdto.getName());
        store.setEmail(rdto.getEmail());
        store.setPassword(rdto.getPassword());
        store.setTheme(rdto.getTheme());
        
        storeService.save(store);
                
        return "redirect:/";
    }


    @GetMapping("/service")
    public String service() {
        return "views/service";
    }
}
