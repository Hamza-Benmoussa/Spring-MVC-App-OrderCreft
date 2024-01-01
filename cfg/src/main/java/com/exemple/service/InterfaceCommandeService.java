package com.exemple.service;

import com.exemple.entity.Client;
import com.exemple.entity.Commande;
import com.exemple.entity.Produit;

import javax.transaction.Transactional;
import java.util.List;

public interface InterfaceCommandeService {

   List<Client> getAllClients();
   List<Produit> getAllProduits();
   List<Commande> getAllCommandes();
   Produit getProduitById(Long produitId);  // Add this method
   @Transactional
   Commande addOrder(Commande commande);
   Commande getOrderById(Long id);

}
