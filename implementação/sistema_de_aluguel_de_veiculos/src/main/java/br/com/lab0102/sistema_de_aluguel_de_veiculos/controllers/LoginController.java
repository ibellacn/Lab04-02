package br.com.lab0102.sistema_de_aluguel_de_veiculos.controllers;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.AgentDTO;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.ClientDTO;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.UserDTO;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.ClientModel;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.services.AgentService;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    AgentService agentService;

    @Autowired
    ClientService clientService;

    @GetMapping(path = "/")
    public String home(){
        return "index";
    }

    @GetMapping(path = "/login")
    public String signIn(@RequestParam String email,
                         @RequestParam String password, @RequestParam String userType,
                         Model model) {
        UserDTO userDTO = new UserDTO(email, password, userType, "");

        if (userDTO.getUserType().equals("agent")) {
            AgentDTO agentDTO = agentService.login(email, password);
            model.addAttribute("agentDTO", agentDTO);
            return "/agent/home";
        } else {
            ClientDTO clientDTO = clientService.login(email, password);
            model.addAttribute("clientDTO", clientDTO);
            return "/client/home";
        }
    }

    @PostMapping(path = "/signUp/client")
    public String signUp(@ModelAttribute ClientDTO clientDTO, Model model) {
        Boolean response = clientService.saveClient(clientDTO);
        clientDTO.setUserType("client");
        if (response){
            model.addAttribute("clientDTO", clientDTO);
            return "/client/home";
        }
        model.addAttribute("message", "Solicitação inválida: Email já registrado na plataforma");
        return "/index";
    }

    @PostMapping(path = "/signUp/agent")
    public String signUp(@ModelAttribute AgentDTO agentDTO, Model model) {
        if (agentDTO.getUserType().equals("bank")) {
            agentDTO.setIsBank(Boolean.TRUE);
        } else {
            agentDTO.setIsBank(Boolean.FALSE);
        }

        Boolean response = agentService.saveAgent(agentDTO);
        if (response){
            model.addAttribute("agentDTO", agentDTO);
            return "/agent/home";
        }
        model.addAttribute("message", "Usuário já registrado");
        return "/index";
    }
}

