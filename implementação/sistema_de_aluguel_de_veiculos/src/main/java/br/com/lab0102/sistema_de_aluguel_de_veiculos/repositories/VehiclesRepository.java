package br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.model.VehiclesModel;

@Repository
public interface VehiclesRepository extends CrudRepository<VehiclesModel, Long> {

}
