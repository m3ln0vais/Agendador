package com.rc20.agendador.controllers;

import com.rc20.agendador.dto.LoginDTO;
import com.rc20.agendador.models.Work;
import com.rc20.agendador.services.ClientService;
import com.rc20.agendador.services.StoreService;
import com.rc20.agendador.services.WorkService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @Autowired
    public ClientService clientService;

    @GetMapping("/page")
    public Page<Work> work(Optional<Integer> page) {
        return workService.find(page.orElse(0));
    }
    
    @PostMapping("/login")
    public ResponseEntity login(LoginDTO loginDTO) {
        return ResponseEntity.of(storeService.login(loginDTO));
    }
    
    @PostMapping("/loginClient")
    public ResponseEntity loginClient(LoginDTO clientDTO) {
        return ResponseEntity.of(clientService.login(clientDTO));
    }
}
