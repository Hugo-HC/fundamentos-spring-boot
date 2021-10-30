package com.fundamentos.springboot.Fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

	private Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
	private MyOperation myOperation;
	
	
	
	public MyBeanWithDependencyImplement(MyOperation myOperation) {
		this.myOperation = myOperation;
	}



	@Override
	public void printWithDependency() {
		LOGGER.info("HEMOS INGRESADO AL METODO printWithDependency");
		// TODO Auto-generated method stub
		int numero = 1;
		LOGGER.debug("EL NUMERO ENVIADO COMO PARAMETRO A LA DEPENDENCIA OPERACION ES : " + numero);
		System.out.println(myOperation.sum(numero));
		System.out.println("Hola desde la implementacion de un bean con dependencia");
	}

}
