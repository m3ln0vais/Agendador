package com.rc20.agendador.services;

import com.rc20.agendador.models.Client;
import com.rc20.agendador.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Desenv. 02
 */

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public Client save(Client client){
        return clientRepository.save(client);
    }
    
    public List<Client> find(){
        return clientRepository.findAll();
    }
    
    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }
    
    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }

//    public void findByLogin(String user, String pass) {
//        clientRepository.findBy
//    }
}
