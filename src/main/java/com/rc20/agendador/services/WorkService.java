package com.rc20.agendador.services;

import com.rc20.agendador.models.Work;
import com.rc20.agendador.repositories.WorkRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Desenv. 02
 */

@Service
public class WorkService {
    
    @Autowired
    private WorkRepository workRepository;
    
    public Work save(Work work){
        return workRepository.save(work);
    }
    
    public List<Work> find(){
        return workRepository.findAll();
    }
    
    public Optional<Work> findById(Long id){
        return workRepository.findById(id);
    }
    
    public void deleteById(Long id){
        workRepository.deleteById(id);
    }

//    public void findByLogin(String user, String pass) {
//        workRepository.findBy
//    }
}
