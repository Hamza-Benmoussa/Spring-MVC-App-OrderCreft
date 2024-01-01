# OrderCraft - Gestion des Commandes

## Aperçu

OrderCraft est une application web développée avec Spring MVC, JPA-Hibernate, et Bootstrap. Elle facilite la gestion des clients, des produits et des commandes.

## Technologies Utilisées

- **Spring MVC:** Framework for building web applications in Java.
- **Thymeleaf:** Modern server-side Java template engine for web and standalone environments.
- **Spring Data JPA (Hibernate):** Framework for easily creating repositories and eliminating boilerplate code.
- **Bootstrap:** CSS framework for developing responsive and mobile-first front-end web projects.



## Fonctionnalités

- **Gestion des Clients :**
  - Ajouter, modifier et supprimer des clients.
  - Rechercher des clients.

- **Gestion des Produits :**
  - Ajouter, modifier et supprimer des produits.
  - Rechercher des produits.

- **Gestion des Commandes :**
  - Afficher toutes les commandes.
  - Passer une nouvelle commande.
- **Rapport de produit**
- 
## Connexion à la Base de Données
# jdbc.X
jdbc.driverClassName=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/spring-mvc
jdbc.user=root
jdbc.pass=

# hibernate.X
hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
hibernate.show_sql=false
hibernate.hbm2ddl.auto=update
hibernate.cache.use_second_level_cache=false
hibernate.cache.use_query_cache=false

spring.h2.console.enabled=true

# Project Configuration

This project is configured to build a robust web application using a combination of Spring MVC, Thymeleaf, and Spring Data JPA with Hibernate.

## 1. Dispatcher Servlet Configuration

**DispatcherServletInit:**
- Initializes the Spring Dispatcher Servlet, a central component for handling web requests.
  
## 2. JPA-Hibernate Configuration

**PersistenceJPAConfig:**
- Configures Java Persistence API (JPA) with Hibernate as the underlying implementation.
- Essential for setting up database-related properties.

## 3. Web Application Context Configuration

**WebApplicationContextConfig:**
- Configures the web application context, focusing on Thymeleaf settings such as template resolvers and view resolvers.
- Responsible for integrating Spring with Thymeleaf for dynamic web content.


## UML Diagramme 
*-Use case :

![image](https://github.com/HAMZA0707/Spring-MVC-App-OrderCreft/assets/89112359/374061ae-d492-4c2d-917f-75f91351b06f)

*-Class :
![image](https://github.com/HAMZA0707/Spring-MVC-App-OrderCreft/assets/89112359/4f8c625f-cf8e-42d4-919d-e69dc1ae950d)

## Video:


https://github.com/HAMZA0707/Spring-MVC-App-OrderCreft/assets/89112359/015524f9-3de0-4532-a6ab-e19e6bd8c50d


