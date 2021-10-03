package br.com.lab0102.sistema_de_aluguel_de_veiculos.models;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressModel {

    @Id
    @GeneratedValue()
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "cep", nullable = false)
    private Integer cep;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private Integer number;

    @OneToOne(mappedBy = "address")
    private ClientModel client;

    public AddressModel() {
    }

    public AddressModel(Integer cep, String district, String city, String state, String country, String street, Integer number) {
        this.cep = cep;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.street = street;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
