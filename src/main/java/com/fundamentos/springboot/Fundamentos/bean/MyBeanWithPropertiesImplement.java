package com.fundamentos.springboot.Fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties{

	private String nombre;
	private String apellido;
	
	
	public MyBeanWithPropertiesImplement(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}


	
	@Override
	public String funtion() {

		return nombre + " - " + apellido;
	}

}
