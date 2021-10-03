package br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.AddressModel;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepository extends JpaRepository<AddressModel, Integer> {
    AddressModel getAddressModelById(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE AddressModel SET cep = ?1, district = ?2, city = ?3, state = ?4, country = ?5, street = ?6, number = ?7 " +
            "WHERE id = ?8")
    void updateAddress(Integer cep, String district, String city, String state,
                       String country, String street, Integer number, Integer id);

    void deleteAddressModelById(Integer id);
}
