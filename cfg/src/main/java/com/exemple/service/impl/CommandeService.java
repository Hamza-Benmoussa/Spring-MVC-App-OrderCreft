package com.exemple.service.impl;

import com.exemple.entity.Client;
import com.exemple.entity.Commande;
import com.exemple.entity.OrderProduit;
import com.exemple.entity.Produit;

import com.exemple.repository.InterfaceCommandeRepository;
import com.exemple.service.InterfaceClientService;
import com.exemple.service.InterfaceCommandeService;
import com.exemple.service.InterfaceProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService implements InterfaceCommandeService {

    @Autowired
    private InterfaceCommandeRepository orderRepository;

    @Autowired
    private InterfaceProduitService produitRepository;

    @Autowired
    private InterfaceClientService clientRepository;

    @Override
    @Transactional
    public Produit getProduitById(Long id) {
        return produitRepository.getProduitById(id);
    }
    @Override
    @Transactional()
    public List<Client> getAllClients() {
        // Retrieve all clients from the database
        return clientRepository.getClients(); // Adjust this based on your actual method in InterfaceClientService
    }

    @Override
    @Transactional()
    public List<Produit> getAllProduits() {
        // Retrieve all produits from the database
        return produitRepository.getProduits(); // Adjust this based on your actual method in InterfaceProduitService
    }
    @Override
    @Transactional
    public Commande getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }
    @Override
    @Transactional()
    public List<Commande> getAllCommandes() {
        return orderRepository.findAll();
    }
    @Override
    @Transactional
    public Commande addOrder(Commande commande) {
        // Set the current date for the order
        commande.setDateOrder(LocalDate.now());

        // Set the totalOrder based on the sum of prixTotal in orderProduits
        double totalOrder = commande.getOrderProduits().stream()
                .mapToDouble(OrderProduit::getTotal)
                .sum();
        commande.setTotalPrix(totalOrder);

        // Save the order
        commande = orderRepository.save(commande);

        // Update the quantities for each produit in orderProduits
        for (OrderProduit orderProduit : commande.getOrderProduits()) {
            Produit produit = orderProduit.getProduit();
            int newQuantity = produit.getQuantiteProduit() - orderProduit.getQuantity();
            produit.setQuantiteProduit(newQuantity);
            produitRepository.addProduit(produit); // Save the updated produit
        }

        // Return the updated order
        return commande;
    }
}
