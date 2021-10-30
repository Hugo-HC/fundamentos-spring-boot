package com.fundamentos.springboot.Fundamentos;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentos.springboot.Fundamentos.bean.MyBean;
import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.Fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.Fundamentos.pojo.UserPojo;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	
	private ComponentDependency componentDependency;
	
	private MyBean myBean;
	
	private MyBeanWithDependency myBeanWithDependency;
	
	private MyBeanWithProperties myBeanWithProperties;
	
	private UserPojo userPojo;

	// Inyeccion de dependencia puede ir o no el autowired
	// @Qualifier Toma el nombre de la clase pero con minuscula cuando tiene mas de una implementacion
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.funtion());
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());
		
		try {
			// error
			int value = 10/0;
			LOGGER.info("MI VALOR :" + value);
		} catch (Exception e) {
			LOGGER.error("ERROR AL DIVIDIR POR 0" + e.getMessage());
		}
	}

}
