package br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.EmployerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface EmployerRepository extends JpaRepository<EmployerModel, Integer> {
    EmployerModel getEmployerModelById(Integer id);

    ArrayList<EmployerModel> getAllByClient_Cpf(Integer cpf);

    @Modifying
    @Transactional
    @Query("UPDATE EmployerModel SET name = ?1, occupation = ?2, income = ?2 WHERE id = ?3")
    void updateEmployer(String name, String occupation, Double income, Integer id);

    void deleteEmployerModelById(Integer id);
}
