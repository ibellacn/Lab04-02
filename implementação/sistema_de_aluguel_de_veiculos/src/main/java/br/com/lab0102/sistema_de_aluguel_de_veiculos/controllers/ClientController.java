package br.com.lab0102.sistema_de_aluguel_de_veiculos.controllers;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.AgentDTO;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.ClientDTO;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping(path = "/update/{cpf}")
    public String update(@PathVariable Integer cpf, @ModelAttribute ClientDTO clientDTO, Model model) {
        ClientDTO updatedClient = clientService.updateClient(cpf, clientDTO);
        model.addAttribute("clientDTO", updatedClient);
        return "/client/home";
    }

    @PostMapping(path = "/delete/{cpf}")
    public String delete(@PathVariable Integer cpf, Model model)
    {
        clientService.deleteClient(cpf);
        return "index";
    }
}
