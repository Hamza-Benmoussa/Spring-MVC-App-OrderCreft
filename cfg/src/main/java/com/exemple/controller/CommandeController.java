package com.exemple.controller;

import com.exemple.entity.Client;
import com.exemple.entity.Commande;
import com.exemple.entity.OrderProduit;
import com.exemple.entity.Produit;
import com.exemple.service.InterfaceClientService;
import com.exemple.service.InterfaceCommandeService;
import com.exemple.service.InterfaceProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private InterfaceCommandeService interfaceCommandeService;
    @Autowired
    private InterfaceProduitService interfaceProduitService;
    @Autowired
    private InterfaceClientService interfaceClientService;

    @GetMapping("/")
    public String showCommandes(Model model) {
        List<Commande> commandes = interfaceCommandeService.getAllCommandes();
        model.addAttribute("commandes", commandes);
        return "commande/showCommandes";
    }
    @GetMapping("/show/{id}")
    public String showOrderDetails(@PathVariable Long id, Model model) {
        Commande order = interfaceCommandeService.getOrderById(id);
        model.addAttribute("order", order);
        return "commande/showCommandes";
    }


    @GetMapping("/add")
    public String showAddCommandeForm(Model model) {
        List<Client> clients = interfaceCommandeService.getAllClients();
        List<Produit> produits = interfaceCommandeService.getAllProduits();
        Commande newCommande = new Commande();
        newCommande.setDateOrder(LocalDate.now());
        model.addAttribute("clients", clients);
        model.addAttribute("produits", produits);
        model.addAttribute("commande", new Commande());
        model.addAttribute("orderProduits", new ArrayList<>()); // For displaying selected products in the form

        return "commande/addCommandeForm";
    }

    @PostMapping("/add")
    public String addCommande(@ModelAttribute Commande commande, @RequestParam("produitIds") List<Long> produitIds, @RequestParam("quantities") List<Integer> quantities) {
        // Create OrderProduit instances based on selected products and quantities
        List<OrderProduit> orderProduits = createOrderProduits(commande, produitIds, quantities);

        // Calculate totalPrix and quantite for the Commande
        double totalPrix = calculateTotalPrix(orderProduits);
        // Set calculated values to the Commande
        commande.setTotalPrix(totalPrix);

        commande.setDateOrder(LocalDate.now());

        // Set the created OrderProduit instances to the Commande
        commande.setOrderProduits(orderProduits);

        // Save the Commande entity
        interfaceCommandeService.addOrder(commande);

        return "redirect:/commandes/show/" + commande.getIdOrder();
    }

    private List<OrderProduit> createOrderProduits(Commande commande, List<Long> produitIds, List<Integer> quantities) {
        List<OrderProduit> orderProduits = new ArrayList<>();

        for (int i = 0; i < produitIds.size(); i++) {
            Produit produit = interfaceCommandeService.getProduitById(produitIds.get(i));
            int quantity = quantities.get(i);

            double total = calculateTotal(produit, quantity);

            OrderProduit orderProduit = new OrderProduit(commande, produit, quantity, total);
            orderProduits.add(orderProduit);
        }

        return orderProduits;
    }

    private double calculateTotal(Produit produit, int quantity) {
        return produit.getPrixProduit() * quantity;
    }

    private double calculateTotalPrix(List<OrderProduit> orderProduits) {
        return orderProduits.stream().mapToDouble(OrderProduit::getTotal).sum();
    }

    private int calculateQuantite(List<OrderProduit> orderProduits) {
        return orderProduits.stream().mapToInt(OrderProduit::getQuantity).sum();
    }

    @GetMapping("/rapport")
    public String generateCommandReport(Model model) {
        List<Commande> commandes = interfaceCommandeService.getAllCommandes();
        List<Produit> mostAddedArticles = interfaceProduitService.getMostAddedArticlesToCommandes();

        // Check if mostAddedArticles is not null before adding to the model
        if (mostAddedArticles != null) {
            model.addAttribute("mostAddedArticles", mostAddedArticles);
        }

        model.addAttribute("commandes", commandes);
        return "rapport"; // Return the rapport.html template
    }
}
