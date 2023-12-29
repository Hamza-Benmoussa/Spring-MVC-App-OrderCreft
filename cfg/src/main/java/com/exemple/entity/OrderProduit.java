package com.exemple.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idOrder")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;

    private int quantity;
    private double total;


    public OrderProduit(Commande commande, Produit produit, int quantity, double total) {
        this.commande = commande;
        this.produit = produit;
        this.quantity = quantity;
        this.total = total;
    }

}
