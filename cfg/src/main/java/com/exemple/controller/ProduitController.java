package com.exemple.controller;

import com.exemple.entity.Produit;
import com.exemple.service.InterfaceProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produits")
@SessionAttributes({"success"})
public class ProduitController {

    @Autowired
    private InterfaceProduitService interfaceProduitService; // Adjust the service interface name

    @GetMapping("/")
    public String showProduits(Model model) {
        List<Produit> produits = interfaceProduitService.getProduits(); // Adjust the method name
        model.addAttribute("produits", produits);
        return "produit/showProduits"; // Assuming you have a showProduits template
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("produit", new Produit()); // Assuming you have a Produit class
        return "produit/addProduitForm"; // Assuming you have an addProduitForm template
    }

    @PostMapping("/add")
    public String addProduit(@ModelAttribute Produit produit , Model model) {
        interfaceProduitService.addProduit(produit); // Adjust the method name
        model.addAttribute("success", "Client created successfully.");
        return "redirect:/produits/";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Produit produit = interfaceProduitService.getProduitById(id); // Adjust the method name
        model.addAttribute("produit", produit);
        return "produit/updateProduitForm"; // Assuming you have an updateProduitForm template
    }

    @PostMapping("/update")
    public String updateProduit(@ModelAttribute Produit produit,Model model) {
        System.out.println(produit);
        interfaceProduitService.updateProduit(produit); // Adjust the method name
        model.addAttribute("success", "Update was successfully.");
        return "redirect:/produits/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable("id") Long id ,Model model) {
        System.out.println("slm");
        interfaceProduitService.deleteProduit(id); // Adjust the method name
        model.addAttribute("success", "Delete was successfully.");
        return "redirect:/produits/";
    }
}
