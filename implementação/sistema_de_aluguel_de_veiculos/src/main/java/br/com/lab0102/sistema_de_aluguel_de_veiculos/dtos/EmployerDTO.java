package br.com.lab0102.sistema_de_aluguel_de_veiculos.dtos;

public class EmployerDTO {
    private Integer id;
    private String name;
    private String occupation;
    private Double income;
    private ClientDTO client;

    public EmployerDTO() {
    }

    public EmployerDTO(Integer id, String name, String occupation, Double income) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
        this.income = income;
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
}
