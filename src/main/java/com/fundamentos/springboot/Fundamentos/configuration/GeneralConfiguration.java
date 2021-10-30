package com.fundamentos.springboot.Fundamentos.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentos.springboot.Fundamentos.pojo.UserPojo;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
	
	@Value("${value.name}")
	private String name;
	
	@Value("${value.apellido}")
	private String apellido;
	
	@Value("${value.random}")
	private String random;
	
	@Value("${jdbc.url}")
	private String jdbcurl;
	
	@Value("${driver}")
	private String driver;
	
	@Value("${username}")
	private String username;
	
	@Value("${password}")
	private String password;
	@Bean
	public MyBeanWithProperties function() {
		return new MyBeanWithPropertiesImplement(name, apellido);
	}
	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourcebuilder = DataSourceBuilder.create();
		dataSourcebuilder.driverClassName(driver);
		dataSourcebuilder.url(jdbcurl);
		dataSourcebuilder.username(username);
		dataSourcebuilder.password(password);
		return dataSourcebuilder.build();
	}
	
}
