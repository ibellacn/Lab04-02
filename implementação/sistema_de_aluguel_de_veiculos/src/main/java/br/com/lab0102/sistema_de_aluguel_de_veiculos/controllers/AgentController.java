package br.com.lab0102.sistema_de_aluguel_de_veiculos.controllers;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.AgentDTO;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/agent")
@CrossOrigin(origins = "*")
public class AgentController {
    @Autowired
    AgentService agentService;

    @GetMapping(path = "")
    public String get(@RequestParam Integer agentId, Model model) {
//        model.addAttribute("agentDTO", agentDTO);
        return "/agent/home";
    }

    @PostMapping(path = "/update/{cnpj}")
    public String update(@PathVariable Integer cnpj, @ModelAttribute AgentDTO agentDTO, Model model) {
        AgentDTO updatedAgent = agentService.updateAgent(cnpj, agentDTO);
        model.addAttribute("agentDTO", updatedAgent);
        return "/agent/home";
    }

    @PostMapping(path = "/delete/{cnpj}")
    public String delete(@PathVariable Integer cnpj, Model model) {
        agentService.deleteAgent(cnpj);
        return "index";
    }
}
