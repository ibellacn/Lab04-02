package br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos;

public class AddressDTO {
    private Integer cep;
    private String district;
    private String city;
    private String state;
    private String country;
    private String street;
    private Integer number;

    public AddressDTO() {
    }

    public AddressDTO(Integer cep, String district, String city,
                      String state, String country, String street, Integer number) {
        this.cep = cep;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.street = street;
        this.number = number;
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
