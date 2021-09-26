package br.com.lab0102.sistema_de_aluguel_de_veiculos.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//@NamedQuery(name = "selecionaTodos", query = "Select v from Vehicle v")
@Entity
@Table(name = "vehicle")
public class VehiclesModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "registration_vehicle", length = 100, nullable = false)
	private String registrationVehicle;
	
	@Column(name = "brand_vehicle", length = 100, nullable = false)
	private String brandVehicle;
	
	@Column(name = "model_vehicle", length = 100, nullable = false)
	private String modelVehicle;
	
	@Column(name = "license_plate_vehicle", length = 100, nullable = false)
	private String licensePlateVehicle;
	
	@Column(name = "age_vehicle", nullable = false)
	private Integer ageVehicle;
	
//	@ManyToOne(fetch = FetchType.Lazy)
//	@JoinColumn(name = "user_id")
//	private User user;

	public Long getId() {
		return id;
	}

	public String getRegistrationVehicle() {
		return registrationVehicle;
	}

	public String getBrandVehicle() {
		return brandVehicle;
	}

	public String getModelVehicle() {
		return modelVehicle;
	}

	public String getLicensePlateVehicle() {
		return licensePlateVehicle;
	}

	public void setLicensePlateVehicle(String licensePlateVehicle) {
		this.licensePlateVehicle = licensePlateVehicle;
	}

	public Integer getAgeVehicle() {
		return ageVehicle;
	}
}
