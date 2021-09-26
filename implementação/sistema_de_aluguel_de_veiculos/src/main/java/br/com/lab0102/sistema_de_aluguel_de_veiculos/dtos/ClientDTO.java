package br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos;

public class ClientDTO extends UserDTO {
    private Integer cpf;
    private String rg;

    public ClientDTO() {
    }

    public ClientDTO(Integer cpf, String rg, String email, String password, String userType, String name) {
        super(email, password, userType, name);
        this.cpf = cpf;
        this.rg = rg;
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
}
