package com.exemple.controller;

import com.exemple.entity.Client;
import com.exemple.service.InterfaceClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private InterfaceClientService interfaceUserService;

    @GetMapping("/")
    public String showClients(Model model) {
        List<Client> clients = interfaceUserService.getUsers();
        model.addAttribute("clients", clients);
        return "client/showClients";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("client", new Client());
        return "client/addClientForm";
    }

    @PostMapping("/add")
    public String addClient(@ModelAttribute Client client) {
        interfaceUserService.addUser(client);
        return "redirect:/clients/";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Client client = interfaceUserService.getUserById(id);
        model.addAttribute("client", client);
        return "client/updateClientForm";
    }

    @PostMapping("/update")
    public String updateClient(@ModelAttribute Client client) {
        System.out.println(client);
        interfaceUserService.updateUser(client);
        return "redirect:/clients/";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id) {
        System.out.println("slm");
        interfaceUserService.deleteUser(id);
        return "redirect:/clients/";
    }
}
