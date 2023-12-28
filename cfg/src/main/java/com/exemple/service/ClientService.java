package com.exemple.service;

import com.exemple.entity.Client;
import com.exemple.repository.InterfaceClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService implements InterfaceClientService {

    @Autowired
    private InterfaceClientRepository interfaceUserRepository;

    @Override
    @Transactional
    public List<Client> getUsers() {
        return interfaceUserRepository.findAll();
    }

    @Override
    @Transactional
    public Client getUserById(Long id) {
        return interfaceUserRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void addUser(Client client) {
        interfaceUserRepository.save(client);
    }

    @Override
    @Transactional
    public void updateUser(Client client) {
        interfaceUserRepository.save(client);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        interfaceUserRepository.deleteById(id);
    }
}
