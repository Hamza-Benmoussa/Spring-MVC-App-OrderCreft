package com.exemple.service;

import com.exemple.entity.Produit;
import com.exemple.repository.InterfaceProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProduitService implements InterfaceProduitService {

    @Autowired
    private InterfaceProduitRepository interfaceProduitRepository;

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
}
