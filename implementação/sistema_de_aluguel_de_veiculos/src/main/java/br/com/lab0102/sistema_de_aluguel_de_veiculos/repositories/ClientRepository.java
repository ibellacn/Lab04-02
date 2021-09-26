package br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ClientRepository extends JpaRepository<ClientModel, Integer> {
    ClientModel getClientModelByCpf(Integer cpf);

    ClientModel getClientModelByEmailAndPassword(String email, String password);

    ClientModel getClientModelByEmail(String email);

    @Modifying
    @Transactional
    @Query("UPDATE ClientModel SET name = ?1, password = ?2 WHERE cpf = ?3")
    void updateClient(String name, String password, Integer cpf);

    void deleteClientModelByCpf(Integer cpf);
}
