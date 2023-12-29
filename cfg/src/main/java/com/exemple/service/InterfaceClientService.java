package com.exemple.service;

import com.exemple.entity.Client;

import java.util.List;

public interface InterfaceClientService {

    List<Client> getClients();

    Client getClientById(Long id);

    Client addClient(Client client);

    Client updateClient(Client client);

    Client deleteClient(Long id);

}
