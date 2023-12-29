package com.exemple.repository;
import com.exemple.entity.OrderProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceCommandeProduitRepository extends JpaRepository<OrderProduit, Integer> {
    @Query("SELECT ca.produit, COUNT(ca) " +
            "FROM OrderProduit ca " +
            "GROUP BY ca.produit " +
            "ORDER BY COUNT(ca) DESC")
    List<Object[]> findMostAddedArticles();
}