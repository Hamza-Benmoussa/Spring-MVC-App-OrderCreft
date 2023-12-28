package com.exemple.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String nameProduit;
    private int prixProduit;
    private int quantiteProduit;

    public Produit(String nameProduit, int prixProduit, int quantiteProduit) {
        this.nameProduit = nameProduit;
        this.prixProduit = prixProduit;
        this.quantiteProduit = quantiteProduit;
    }
}
