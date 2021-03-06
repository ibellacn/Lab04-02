package br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.VehiclesModel;

public interface VehiclesRepository extends JpaRepository<VehiclesModel, Integer> {

	@Query ("select c from Client c where c.client = :client")
	public List<Vehicle> listvehiclePerClent(@Param("client") ClientModel client)
	
	
}
