package com.shop.candy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.shop.candy.repository.ClientesRepository;
import com.shop.candy.models.Clientes;

@SpringBootApplication
public class CandyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandyApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ClientesRepository clientesRepository) {
		return args -> {

			System.out.println("--- Agregando Datos Manualmente ---");

			Clientes c1 = new Clientes("Goku","kakaroto","Saturno","hombre");

			clientesRepository.save(c1);

			System.out.println("--- DATOS GUARDADOS EN BD ---");
		};
	}
}