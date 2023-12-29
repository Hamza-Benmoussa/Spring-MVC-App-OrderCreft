package com.exemple.service.impl;

import com.exemple.entity.Client;
import com.exemple.repository.InterfaceClientRepository;
import com.exemple.service.InterfaceClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService implements InterfaceClientService {

    @Autowired
    private InterfaceClientRepository interfaceClientRepository; // Corrected variable name

    @Override
    @Transactional
    public List<Client> getClients() {
        return interfaceClientRepository.findAll();
    }

    @Override
    @Transactional
    public Client getClientById(Long id) {
        return interfaceClientRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Client addClient(Client client) {
        return interfaceClientRepository.save(client);
    }

    @Override
    @Transactional
    public Client updateClient(Client client) {
        return interfaceClientRepository.save(client);
    }

    @Override
    @Transactional
    public Client deleteClient(Long id) {
        Client client = getClientById(id);
        if (client != null) {
            interfaceClientRepository.deleteById(id);
        }
        return client;
    }
}
