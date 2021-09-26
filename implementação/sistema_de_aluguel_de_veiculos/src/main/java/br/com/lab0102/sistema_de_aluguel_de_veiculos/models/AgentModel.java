package br.com.lab0102.sistema_de_aluguel_de_veiculos.models;
import javax.persistence.*;

@Entity
@Table(name = "agent")
public class AgentModel {
    private Integer cnpj;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "isBank", nullable = false)
    private Boolean isBank;

    public AgentModel() {

    }

    public AgentModel(Integer cnpj, String email, String password, String name, Boolean isBank) {
        this.cnpj = cnpj;
        this.email = email;
        this.password = password;
        this.name = name;
        this.isBank = isBank;
    }

    @Id
    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
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

    public Boolean getIsBank() {
        return isBank;
    }

    public void setIsBank(Boolean isBank) {
        isBank = isBank;
    }
}
