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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String nameClient;
    private String emailClient;
    private String addressClient;

    public Client(String nameClient, String emailClient, String addressClient) {
        this.nameClient = nameClient;
        this.emailClient = emailClient;
        this.addressClient = addressClient;
    }
}
