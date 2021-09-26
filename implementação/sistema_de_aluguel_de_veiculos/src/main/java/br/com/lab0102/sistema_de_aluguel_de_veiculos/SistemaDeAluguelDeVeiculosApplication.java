package br.com.lab0102.sistema_de_aluguel_de_veiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
public class SistemaDeAluguelDeVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeAluguelDeVeiculosApplication.class, args);
	}

}
