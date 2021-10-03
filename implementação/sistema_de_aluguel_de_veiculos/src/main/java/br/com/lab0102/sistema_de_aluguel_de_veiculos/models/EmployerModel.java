package br.com.lab0102.sistema_de_aluguel_de_veiculos.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employer")
public class EmployerModel {

    @Id
    @GeneratedValue()
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "occupation", nullable = false)
    private String occupation;

    @Column(name = "income", nullable = false)
    private Double income;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_cpf", referencedColumnName = "cpf")
    private ClientModel client;

    public EmployerModel() {
    }

    public EmployerModel(Integer id, String name, String occupation, Double income, ClientModel client) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
        this.income = income;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }
}
