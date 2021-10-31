package com.fundamentos.springboot.Fundamentos.caseuse;

import org.springframework.stereotype.Component;

import com.fundamentos.springboot.Fundamentos.service.UserService;

@Component
public class DeleteUser {
	private UserService userService;
	
	public DeleteUser(UserService userService){
		this.userService = userService;
	}

	public void remove(Long id) {
		userService.delete(id);		
	}
}
