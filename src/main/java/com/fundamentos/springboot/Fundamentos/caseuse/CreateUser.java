package com.fundamentos.springboot.Fundamentos.caseuse;

import org.springframework.stereotype.Component;

import com.fundamentos.springboot.Fundamentos.entity.User;
import com.fundamentos.springboot.Fundamentos.service.UserService;

@Component
public class CreateUser {
	private UserService userService;
	
	public CreateUser(UserService userService){
		this.userService = userService;
	}

	public User save(User newUser) {
		return userService.save(newUser);
	}
}
