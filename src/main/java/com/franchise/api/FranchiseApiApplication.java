package com.franchise.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class FranchiseApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FranchiseApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("⏳ Esperando que MySQL esté completamente disponible...");
		Thread.sleep(15000);
		System.out.println("✅ Continuando con la inicialización del backend...");
	}
}
