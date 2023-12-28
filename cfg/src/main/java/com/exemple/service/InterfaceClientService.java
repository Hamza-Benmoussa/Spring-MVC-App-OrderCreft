package com.exemple.service;

import com.exemple.entity.Client;

import java.util.List;

public interface InterfaceClientService {

    List<Client> getUsers();

    Client getUserById(Long id);

    void addUser(Client client);

    void updateUser(Client client);

    void deleteUser(Long id);
}
