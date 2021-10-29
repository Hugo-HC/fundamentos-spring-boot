package com.fundamentos.springboot.Fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{

	@Override
	public void saludar() {
		// TODO Auto-generated method stub
		System.out.println("Hola mundo desde mi componente dos");
	}

}
