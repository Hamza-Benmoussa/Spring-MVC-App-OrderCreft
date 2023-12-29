package com.exemple.repository;

import com.exemple.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterfaceCommandeRepository extends JpaRepository<Commande,Long> {
    Optional<Commande> findById(Long id);

}
