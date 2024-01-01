package com.exemple.service.impl;

import com.exemple.entity.OrderProduit;
import com.exemple.repository.InterfaceCommandeProduitRepository;
import com.exemple.service.InterfaceCommandeProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeProduitService implements InterfaceCommandeProduitService {

    @Autowired
    private InterfaceCommandeProduitRepository interfaceCommandeProduitRepository;
    @Override
    public List<OrderProduit> getOrderProduits() {
        return interfaceCommandeProduitRepository.findAll();
    }

    @Override
    public OrderProduit addOrderProduit(OrderProduit orderProduit) {
        return interfaceCommandeProduitRepository.save(orderProduit);
    }
}
