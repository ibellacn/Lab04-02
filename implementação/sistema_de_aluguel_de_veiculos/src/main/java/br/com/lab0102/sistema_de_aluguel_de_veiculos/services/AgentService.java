package br.com.lab0102.sistema_de_aluguel_de_veiculos.services;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos.AgentDTO;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.AgentModel;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public AgentDTO login(String email, String password) {
        AgentModel agent = agentRepository.getAgentModelByEmailAndPassword(email, password);
        AgentDTO agentDTO = new AgentDTO(agent.getCnpj(), agent.getEmail(),
                agent.getPassword(), "agent", agent.getName(), agent.getIsBank());

        return agentDTO;
    }

    public AgentDTO getAgent(Integer cnpj) {
        AgentModel agent = agentRepository.getAgentModelByCnpj(cnpj);

        return new AgentDTO(agent.getCnpj(), agent.getEmail(),
                agent.getPassword(), "agent", agent.getName(), agent.getIsBank());
    }

    public Boolean isRegistered(String email) {
        AgentModel agent = agentRepository.getAgentModelByEmail(email);
        return (agent != null)? Boolean.TRUE : Boolean.FALSE;
    }

    public Boolean saveAgent(AgentDTO agentDTO) {
        if (isRegistered(agentDTO.getEmail())){
            return Boolean.FALSE;
        }
        AgentModel agentModel = new AgentModel(agentDTO.getCnpj(), agentDTO.getEmail(),
                agentDTO.getPassword(), agentDTO.getName(), agentDTO.getIsBank());
        agentRepository.save(agentModel);
        return Boolean.TRUE;
    }

    public AgentDTO updateAgent(Integer cnpj, AgentDTO agentDTO) {
        agentRepository.updateAgent(agentDTO.getName(), agentDTO.getPassword(), cnpj);
        return getAgent(cnpj);
    }

    @Transactional
    public void deleteAgent(Integer cnpj) {
        agentRepository.deleteAgentModelByCnpj(cnpj);
    }

}
