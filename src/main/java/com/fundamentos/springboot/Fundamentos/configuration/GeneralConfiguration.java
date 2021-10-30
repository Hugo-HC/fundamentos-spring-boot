package com.fundamentos.springboot.Fundamentos.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentos.springboot.Fundamentos.pojo.UserPojo;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
	
	@Value("${value.name}")
	private String name;
	
	@Value("${value.apellido}")
	private String apellido;
	
	@Value("${value.random}")
	private String random;
	
	@Bean
	public MyBeanWithProperties function() {
		return new MyBeanWithPropertiesImplement(name, apellido);
	}
	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourcebuilder = DataSourceBuilder.create();
		dataSourcebuilder.driverClassName("org.h2.Driver");
		dataSourcebuilder.url("jdbc:h2:mem:testdb");
		dataSourcebuilder.username("sa");
		dataSourcebuilder.password("");
		return dataSourcebuilder.build();
	}
	
}
