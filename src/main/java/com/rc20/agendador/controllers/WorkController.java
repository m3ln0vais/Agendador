package com.rc20.agendador.controllers;

import com.rc20.agendador.models.Store;
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
    public String work(Model model, Optional<Integer> page, Optional<String> q) {
        model.addAttribute("page", q.isPresent()
                ? workService.findByName(page.orElse(0), q.orElse(""))
                : workService.find(page.orElse(0)));
        return "views/work/work";
    }

    @GetMapping("/form")
    public String workForm(Model model, Optional<Long> id) {
        model.addAttribute("work",
                id.isPresent() ? workService.findById(id.get()).get() : new Work());
        return "views/work/work-form";
    }

    @PostMapping
    public String save(Model model, @Valid Work work, Long storeId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("work", work);
            return "views/work/work-form";
        }
        
        work.setStore( new Store(storeId));
        workService.save(work);

        return "redirect:/work";
    }
}
