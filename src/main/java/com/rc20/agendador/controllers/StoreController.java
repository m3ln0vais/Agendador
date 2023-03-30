package com.rc20.agendador.controllers;

import com.rc20.agendador.enuns.Themes;
import com.rc20.agendador.models.Store;
import com.rc20.agendador.services.StoreService;
import jakarta.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.util.Arrays.asList;
import java.util.Base64;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Desenv. 02
 */
@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/form")
    public String storeForm(Model model, Optional<Long> id) {
        model.addAttribute("store",
                id.isPresent() ? storeService.findById(id.get()).get() : new Store());
        model.addAttribute("themes", asList(Themes.values()));
        return "views/store/store-form";
    }

    @PostMapping
    public String register(Model model, @Valid Store store, BindingResult bindingResult, @RequestParam MultipartFile file) throws IOException {
       
        
        if (!file.isEmpty()) {
            File img = new File(file.getOriginalFilename());
            if (!img.exists()) {
                img.createNewFile();
            }
            Files.write(img.toPath(), file.getBytes());
            byte[] x = Files.readAllBytes(img.toPath());
            byte[] b = Base64.getEncoder().encode(x);
            store.setImg(b);
        }
        
        if (bindingResult.hasErrors()) {

            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("store", store);
            model.addAttribute("themes", asList(Themes.values()));
            return "views/store/store-form";
        }

        Store save = storeService.save(store);
        return "redirect:/store?id=" + save.getId();
    }
}
