package com.rc20.agendador.services;

import com.rc20.agendador.models.Store;
import com.rc20.agendador.repositories.StoreRepository;
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
    
    public Store save(Store store){
        return storeRepository.save(store);
    }
    
    public List<Store> find(){
        return storeRepository.findAll();
    }
    
    public Optional<Store> findById(Long id){
        return storeRepository.findById(id);
    }
    
    public void deleteById(Long id){
        storeRepository.deleteById(id);
    }
}
