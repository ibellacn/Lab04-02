package br.com.lab0102.sistema_de_aluguel_de_veiculos.controllers;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.*;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(path = "/client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping(path = "/getAddress/{cpf}")
    public String getAddress(@PathVariable Integer cpf, Model model) {
        AddressDTO addressDTO = clientService.getAddressByCpf(cpf);

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setCpf(cpf);

        model.addAttribute("addressDTO", addressDTO);
        model.addAttribute("clientDTO", clientDTO);
        return "/client/formAddress";
    }

    @GetMapping(path = "/getEmployers/{cpf}")
    public String getEmployers(@PathVariable Integer cpf, Model model) {
        ArrayList<EmployerDTO> employersListDTO = clientService.getAllEmployerByCpf(cpf);

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setCpf(cpf);

        model.addAttribute("employersListDTO", employersListDTO);
        model.addAttribute("clientDTO", clientDTO);
        return "/client/formEmployer";
    }

    @PostMapping(path = "/update/{cpf}")
    public String update(@PathVariable Integer cpf, @ModelAttribute ClientDTO clientDTO, Model model) {
        ClientDTO updatedClient = clientService.updateClient(cpf, clientDTO);
        model.addAttribute("clientDTO", updatedClient);
        return "/client/home";
    }

    @PostMapping(path = "/updateAddress/{cpf}")
    public String updateAddress(@PathVariable Integer cpf, @ModelAttribute AddressDTO addressDTO, Model model) {
        Boolean response = clientService.updateAddress(addressDTO, cpf);

        if (response){
            model.addAttribute("addressDTO", addressDTO);
            return "/client/home";
        }
        model.addAttribute("response", false);
        return "/client/home";

    }

    @PostMapping(path = "/updateEmployer/{cpf}/{id}")
    public String updateEmployer(@PathVariable Integer cpf, @PathVariable Integer id,
                                 @ModelAttribute EmployerDTO employerDTO, Model model) {
        ArrayList<EmployerDTO> employerDTOList = clientService.updateEmployer(employerDTO, cpf, id);

        model.addAttribute("employerDTOList", employerDTOList);
        return "/client/home";
    }

    @PostMapping(path = "/delete/{cpf}")
    public String delete(@PathVariable Integer cpf, Model model)
    {
        clientService.deleteClient(cpf);
        return "index";
    }

    @PostMapping(path = "/deleteEmployer/{cpf}/{id}")
    public String deleteEmployer(@PathVariable Integer cpf, @PathVariable Integer id, Model model)
    {
        ArrayList<EmployerDTO> employerDTOList = clientService.deleteEmployer(id, cpf);
        model.addAttribute("employerDTOList", employerDTOList);
        return "/client/home";
    }

//    private String returnClient(Integer cpf){
//        ClientDTO clientDTO = clientService.getClient(cpf);
//
//        model.addAttribute("clientDTO", clientDTO);
//        model.addAttribute("addressDTO", clientDTO.getAddress());
//
//        return "/client/home";
//    }
}
