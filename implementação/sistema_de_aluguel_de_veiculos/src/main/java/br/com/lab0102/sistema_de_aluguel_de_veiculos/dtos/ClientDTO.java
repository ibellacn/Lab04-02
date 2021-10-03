package br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos;

public class ClientDTO extends UserDTO {
    private Integer cpf;
    private String rg;
    private AddressDTO address;

    public ClientDTO() {
    }

    public ClientDTO(String email, String password, String userType,
                     String name, Integer cpf, String rg, AddressDTO address) {
        super(email, password, userType, name);
        this.cpf = cpf;
        this.rg = rg;
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
