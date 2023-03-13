package com.rc20.agendador.controllers;

import com.rc20.agendador.models.Work;
import com.rc20.agendador.services.WorkService;
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
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private WorkService workService;

    @GetMapping
    public String work(Model model, Optional<Long> id) {
        model.addAttribute("work", 
                id.isPresent() ? workService.findById(id.get()).get() : new Work());
//        model.addAttribute("themes", asList(Themes.values()));
        return "views/work";
    }
    
    

    @PostMapping
    public String register(Model model, @Valid Work work, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("work", work);
            return "views/work";
        }
        
        Work save = workService.save(work);

        return "redirect:/work?id=" + save.getId();
    }
}
