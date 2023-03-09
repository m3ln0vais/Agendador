
package com.rc20.agendador.controllers;

import com.rc20.agendador.models.Store;
import com.rc20.agendador.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Desenv. 02
 */

@RestController
public class APIController {
    
     @Autowired
    private StoreService storeService;
     
//     public ResponseEntity<Store> login(String user, String pass){;
//         storeService.findByLogin(user, pass);
//     }
}
