package com.fundamentos.springboot.Fundamentos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundamentos.springboot.Fundamentos.caseuse.GetUser;
import com.fundamentos.springboot.Fundamentos.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	//create, get, delete, update
	
	private GetUser getUser;
	
	public UserRestController(GetUser getUser) {
		this.getUser = getUser;
	}
	
	@GetMapping("/")
	List<User> get(){
		return getUser.getAll();
	}
}
