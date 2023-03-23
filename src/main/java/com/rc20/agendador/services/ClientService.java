package com.rc20.agendador.services;

import com.rc20.agendador.models.Client;
import com.rc20.agendador.models.Work;
import com.rc20.agendador.repositories.ClientRepository;
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
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> find() {
        return clientRepository.findAll();
    }

    public Page<Client> find(Integer page) {
        page = Optional.ofNullable(page).orElse(0);
        page = page < 0 ? 0 : page;
        return clientRepository.findAll(PageRequest.of(page, 5));
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public Page<Client> findByName(Integer page, String name) {
        page = Optional.ofNullable(page).orElse(0);
        page = page < 0 ? 0 : page;
        return clientRepository.findByNameContainingIgnoreCase(name, PageRequest.of(page, 2));
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
