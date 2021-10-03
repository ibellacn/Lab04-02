package br.com.lab0102.sistema_de_aluguel_de_veiculos.models;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class ClientModel {

    @Id
    @Column(name = "cpf", nullable = false)
    private Integer cpf;

    @Column(name = "rg", nullable = false)
    private String rg;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressModel address;

    public ClientModel() {
    }

    public ClientModel(Integer cpf, String rg, String email, String password, String name, AddressModel address) {
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }
}
