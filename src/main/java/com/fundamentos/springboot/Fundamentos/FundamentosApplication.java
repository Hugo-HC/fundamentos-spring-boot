package com.fundamentos.springboot.Fundamentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentos.springboot.Fundamentos.component.ComponentDependency;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{

	private ComponentDependency componentDependency;
	
	// Inyeccion de dependencia puede ir o no el autowired
	// @Qualifier Toma el nombre de la clase pero con minuscula cuando tiene mas de una implementacion
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency) {
		this.componentDependency = componentDependency;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		componentDependency.saludar();
	}

}
