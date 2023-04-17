package com.rc20.agendador.services;

import com.rc20.agendador.dto.LoginDTO;
import com.rc20.agendador.models.Store;
import com.rc20.agendador.repositories.StoreRepository;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Desenv. 02
 */
@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store save(Store store) {
        return storeRepository.save(store);
    }

    public List<Store> find() {
        return storeRepository.findAll();
    }

    public Optional<Store> findById(Long id) throws IOException {
        Optional<Store> s = storeRepository.findById(id);
        
        if(s.isPresent()){
            if(s.get().getImg() == null){
                byte[] file = getClass().getResourceAsStream("/static/img/store.jpg").readAllBytes();
                byte[] x = Base64.getEncoder().encode(file);
                s.get().setImg(x);
            }
        }
        
        return s;
    }

    public void deleteById(Long id) {
        storeRepository.deleteById(id);
    }

    public Optional<Store> login(LoginDTO loginDTO) {
        Optional<Store> store = storeRepository.findByEmail(loginDTO.getEmail());
        if (store.isPresent()) {
            if (loginDTO.getPassword().equals(store.get().getPassword())) {
                store.get().setRemember(loginDTO.getRemember());
                return store;
            }
        }
        return Optional.empty();
    }
}
