package br.com.lab0102.sistema_de_aluguel_de_veiculos.services;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.AddressDTO;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.ClientDTO;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.EmployerDTO;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.AddressModel;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.ClientModel;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.EmployerModel;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories.AddressRepository;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories.ClientRepository;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EmployerRepository employerRepository;

    private ClientDTO getClientDTO(ClientModel client) {
        AddressDTO addressDTO = new AddressDTO(client.getAddress().getCep(), client.getAddress().getDistrict(),
                client.getAddress().getCity(), client.getAddress().getState(), client.getAddress().getCountry(),
                client.getAddress().getStreet(), client.getAddress().getNumber());

        return new ClientDTO(client.getEmail(), client.getPassword(), "client",
                client.getName(), client.getCpf(), client.getRg(), addressDTO);
    }

    public ClientDTO login(String email, String password) {
        ClientModel client = clientRepository.getClientModelByEmailAndPassword(email, password);
        return getClientDTO(client);
    }

    public ClientDTO getClient(Integer cpf) {
        ClientModel client = clientRepository.getClientModelByCpf(cpf);
        return getClientDTO(client);
    }

    private ArrayList<EmployerDTO> getAllEmployerByCpf(Integer cpf) {
        ArrayList<EmployerDTO> employerDTOS = new ArrayList<>();
        ArrayList<EmployerModel> employerModels = employerRepository.getAllByClient_Cpf(cpf);

        for (EmployerModel employerModel : employerModels){
            EmployerDTO employerDTO = new EmployerDTO(employerModel.getId(), employerModel.getName(),
                    employerModel.getOccupation(), employerModel.getIncome());

            employerDTOS.add(employerDTO);
        }
        return employerDTOS;
    }

    private Boolean isRegistered(String email) {
        ClientModel client = clientRepository.getClientModelByEmail(email);
        return (client != null)? Boolean.TRUE : Boolean.FALSE;
    }

    public Boolean saveClient(ClientDTO clientDTO, AddressDTO addressDTO) {
        if (isRegistered(clientDTO.getEmail())){
            return Boolean.FALSE;
        }

        AddressModel addressModel = new AddressModel(addressDTO.getCep(), addressDTO.getDistrict(),
                addressDTO.getCity(), addressDTO.getState(), addressDTO.getCountry(),
                addressDTO.getStreet(), addressDTO.getNumber());

        ClientModel clientModel = new ClientModel(clientDTO.getCpf(), clientDTO.getRg(), clientDTO.getEmail(),
                clientDTO.getPassword(), clientDTO.getName(), addressModel);
        clientRepository.save(clientModel);

        return Boolean.TRUE;
    }

    private boolean hasExceeded(Integer cpf) {
        return employerRepository.getAllByClient_Cpf(cpf).size() >= 3;
    }

    public Boolean saveEmployer(Integer cpf, EmployerDTO employerDTO) {
        if (hasExceeded(cpf)){
            return Boolean.FALSE;
        }

        ClientModel clientModel = new ClientModel();
        clientModel.setCpf(cpf);

        EmployerModel employerModel = new EmployerModel(0, employerDTO.getName(), employerDTO.getOccupation(),
                employerDTO.getIncome(), clientModel);

        employerRepository.save(employerModel);
        return Boolean.TRUE;
    }

    @Transactional
    public ClientDTO updateClient(Integer cpf, ClientDTO clientDTO) {
        clientRepository.updateClient(clientDTO.getName(), clientDTO.getPassword(), cpf);
        return getClient(cpf);
    }

    @Transactional
    public Boolean updateAddress(AddressDTO addressDTO, Integer id) {
        addressRepository.updateAddress(addressDTO.getCep(), addressDTO.getDistrict(),
                addressDTO.getCity(), addressDTO.getState(), addressDTO.getCountry(),
                addressDTO.getStreet(), addressDTO.getNumber(), id);
        return Boolean.TRUE;
    }

    @Transactional
    public ArrayList<EmployerDTO> updateEmployer(EmployerDTO employerDTO, Integer cpf, Integer id) {
        employerRepository.updateEmployer(employerDTO.getName(), employerDTO.getOccupation(),
                employerDTO.getIncome(), id);
        return getAllEmployerByCpf(cpf);
    }

    @Transactional
    public void deleteClient(Integer cpf) {
        clientRepository.deleteClientModelByCpf(cpf);
    }

    @Transactional
    public ArrayList<EmployerDTO> deleteEmployer(Integer id, Integer cpf) {
        employerRepository.deleteEmployerModelById(id);
        return getAllEmployerByCpf(cpf);
    }
}
