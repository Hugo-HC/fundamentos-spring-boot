package com.fundamentos.springboot.Fundamentos.caseuse;

import java.util.List;

import com.fundamentos.springboot.Fundamentos.entity.User;
import com.fundamentos.springboot.Fundamentos.service.UserService;

public class GetUserImplement implements GetUser{
	
	private UserService userService;
	
	public GetUserImplement(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public List<User> getAll() {
		return userService.getAllUsers();
	}

}
