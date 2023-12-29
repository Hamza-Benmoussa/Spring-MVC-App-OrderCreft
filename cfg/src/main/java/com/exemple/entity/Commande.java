package com.exemple.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    private LocalDate dateOrder;
    private Double totalPrix;  // Corrected attribute name

    @Enumerated(EnumType.STRING)
    private Status statusOrder;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduit> orderProduits;
    public Commande(Client client, LocalDate dateOrder, Double totalPrix, Status statusOrder, List<OrderProduit> orderProduits) {
        this.client = client;
        this.dateOrder = dateOrder;
        this.totalPrix = totalPrix;
        this.statusOrder = statusOrder;
        this.orderProduits = orderProduits;


    }

    public int getQuantite() {
        return orderProduits.stream().mapToInt(OrderProduit::getQuantity).sum();
    }

}
