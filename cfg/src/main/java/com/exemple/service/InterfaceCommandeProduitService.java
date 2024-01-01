package com.exemple.service;

import com.exemple.entity.OrderProduit;

import java.util.List;

public interface InterfaceCommandeProduitService {
    List<OrderProduit> getOrderProduits();
    OrderProduit addOrderProduit(OrderProduit orderProduit);
}
