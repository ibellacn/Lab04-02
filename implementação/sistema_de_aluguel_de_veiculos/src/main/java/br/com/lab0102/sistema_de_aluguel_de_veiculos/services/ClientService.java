package br.com.lab0102.sistema_de_aluguel_de_veiculos.services;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.AgentDTO;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.ClientDTO;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.ClientModel;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO login(String email, String password) {
        ClientModel client = clientRepository.getClientModelByEmailAndPassword(email, password);
        ClientDTO ClientDTO = new ClientDTO(client.getCpf(), client.getRg(), client.getEmail(),
                client.getPassword(), "client", client.getName());

        return ClientDTO;
    }

    public ClientDTO getClient(Integer cpf) {
        ClientModel client = clientRepository.getClientModelByCpf(cpf);

        return new ClientDTO(client.getCpf(), client.getRg(), client.getEmail(),
                client.getPassword(), "client", client.getName());
    }

    public Boolean isRegistered(String email) {
        ClientModel client = clientRepository.getClientModelByEmail(email);
        return (client != null)? Boolean.TRUE : Boolean.FALSE;
    }

    public Boolean saveClient(ClientDTO clientDTO) {
        if (isRegistered(clientDTO.getEmail())){
            return Boolean.FALSE;
        }
        ClientModel clientModel = new ClientModel(clientDTO.getCpf(), clientDTO.getRg(), clientDTO.getEmail(),
                clientDTO.getPassword(), clientDTO.getName());
        clientRepository.save(clientModel);
        return Boolean.TRUE;
    }

    @Transactional
    public ClientDTO updateClient(Integer cpf, ClientDTO clientDTO) {
        clientRepository.updateClient(clientDTO.getName(), clientDTO.getPassword(), cpf);
        return getClient(cpf);
    }

    @Transactional
    public void deleteClient(Integer cpf) {
        clientRepository.deleteClientModelByCpf(cpf);
    }
}
