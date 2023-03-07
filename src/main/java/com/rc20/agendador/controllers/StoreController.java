/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rc20.agendador.controllers;

import com.rc20.agendador.models.Store;
import com.rc20.agendador.services.StoreService;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Desenv. 02
 */
@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public String store(Model model, Optional<Long> id) {
        model.addAttribute("store", 
                id.isPresent() ? storeService.findById(id.get()).get() : new Store());
        return "views/store";
    }

    @PostMapping
    public String register(Model model, @Valid Store store, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("store", store);
            return "views/store";
        }
        
        Store save = storeService.save(store);

        return "redirect:/store?id=" + save.getId();
    }
}
