package com.exemple.service.impl;

import com.exemple.entity.Produit;
import com.exemple.repository.InterfaceCommandeProduitRepository;
import com.exemple.repository.InterfaceProduitRepository;
import com.exemple.service.InterfaceProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitService implements InterfaceProduitService {

    @Autowired
    private InterfaceProduitRepository interfaceProduitRepository;
    private InterfaceCommandeProduitRepository interfaceCommandeProduitRepository;

    @Override
    @Transactional
    public List<Produit> getProduits() {
        return interfaceProduitRepository.findAll();
    }

    @Override
    @Transactional
    public Produit getProduitById(Long id) {
        return interfaceProduitRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Produit addProduit(Produit produit) {
        return interfaceProduitRepository.save(produit);
    }

    @Override
    @Transactional
    public Produit updateProduit(Produit produit) {
        return interfaceProduitRepository.save(produit);
    }

    @Override
    @Transactional
    public Produit deleteProduit(Long id) {
        Produit produit = getProduitById(id);
        if (produit != null) {
            interfaceProduitRepository.deleteById(id);
        }
        return produit;
    }
    @Override
    public List<Produit> getMostAddedArticlesToCommandes() {
        // Fetch a list of articles ordered by the count of associated CommandeArticles

        List<Object[]> result = interfaceCommandeProduitRepository.findMostAddedArticles();

        // Map the result to Article entities
        List<Produit> mostAddedArticles = result.stream()
                .map(objArray -> (Produit) objArray[0])
                .collect(Collectors.toList());

        return mostAddedArticles;
    }
}
