package com.rc20.agendador.controllers;

import com.rc20.agendador.models.Work;
import com.rc20.agendador.services.StoreService;
import com.rc20.agendador.services.WorkService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Desenv. 02
 */
@RestController
public class APIController {

    @Autowired
    private StoreService storeService;
    
    @Autowired
    private WorkService workService;

    @GetMapping("/page")
    public Page<Work> work(Optional<Integer> page) {
        return workService.find(page.orElse(0));
    }

//     public ResponseEntity<Store> login(String user, String pass){;
//         storeService.findByLogin(user, pass);
//     }
}
