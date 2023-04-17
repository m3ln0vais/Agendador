package com.rc20.agendador.services;

import com.rc20.agendador.dto.LoginDTO;
import com.rc20.agendador.models.Client;
import com.rc20.agendador.models.Scheduling;
import com.rc20.agendador.repositories.SchedulingRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author Desenv. 02
 */
@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;

    public Scheduling save(Scheduling scheduling) {
        return schedulingRepository.save(scheduling);
    }

    public List<Scheduling> find() {
        return schedulingRepository.findAll();
    }

    public Page<Scheduling> find(Integer page) {
        page = Optional.ofNullable(page).orElse(0);
        page = page < 0 ? 0 : page;
        return schedulingRepository.findAll(PageRequest.of(page, 5));
    }

    public Optional<Scheduling> findById(Long id) {
        return schedulingRepository.findById(id);
    }

    public void deleteById(Long id) {
        schedulingRepository.deleteById(id);
    }
    
    public List<Scheduling> findByClient(Client client){
        return schedulingRepository.findByClient(client);
    }

}
