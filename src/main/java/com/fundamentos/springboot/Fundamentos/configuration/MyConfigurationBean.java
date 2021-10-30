package com.fundamentos.springboot.Fundamentos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentos.springboot.Fundamentos.bean.MyBean;
import com.fundamentos.springboot.Fundamentos.bean.MyBean2Implement;
import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithDependencyImplement;
import com.fundamentos.springboot.Fundamentos.bean.MyBeanImplement;
import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.Fundamentos.bean.MyOperation;
import com.fundamentos.springboot.Fundamentos.bean.MyOperationImplement;

@Configuration
public class MyConfigurationBean {
	
	@Bean
	public MyBean beanOperation() {
		// return new MyBeanImplement();
		return new MyBean2Implement();
	}
	
	@Bean
	public MyOperation beanOperationOperation() {
		// return new MyBeanImplement();
		return new MyOperationImplement();
	}
	
	@Bean
	public MyBeanWithDependency beanOperationOperationWithDependency(MyOperation myOperation) {
		return new MyBeanWithDependencyImplement(myOperation);
	}
}
