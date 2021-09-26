package br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos;

public class AgentDTO extends UserDTO {
    private Integer cnpj;
    private Boolean isBank;

    public AgentDTO() {
    }

    public AgentDTO(Integer cnpj, String email, String password, String userType, String name, Boolean isBank) {
        super(email, password, userType, name);
        this.cnpj = cnpj;
        this.isBank = isBank;

    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public Boolean getIsBank() {
        return isBank;
    }

    public void setIsBank(Boolean isBank) {
        this.isBank = isBank;
    }
}
