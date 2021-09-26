package br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.AgentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AgentRepository extends JpaRepository<AgentModel, Integer> {
    AgentModel getAgentModelByEmailAndPassword(String email, String password);

    AgentModel getAgentModelByEmail(String email);

    AgentModel getAgentModelByCnpj(Integer cnpj);

    @Modifying
    @Transactional
    @Query("UPDATE AgentModel SET name = ?1, password = ?2 WHERE cnpj = ?3")
    void updateAgent(String name, String password, Integer cnpj);

    void deleteAgentModelByCnpj(Integer cnpj);
}
