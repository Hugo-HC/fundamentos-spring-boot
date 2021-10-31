package com.fundamentos.springboot.Fundamentos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentos.springboot.Fundamentos.caseuse.GetUser;
import com.fundamentos.springboot.Fundamentos.caseuse.GetUserImplement;
import com.fundamentos.springboot.Fundamentos.service.UserService;

@Configuration
public class CaseUseConfiguration {
	
	@Bean
	GetUser getUser(UserService userService) {
		return new GetUserImplement(userService);
	}
}
