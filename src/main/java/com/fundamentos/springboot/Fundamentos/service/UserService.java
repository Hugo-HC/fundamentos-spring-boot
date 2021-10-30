package com.fundamentos.springboot.Fundamentos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.fundamentos.springboot.Fundamentos.entity.User;
import com.fundamentos.springboot.Fundamentos.repository.UserRepository;

@Service
public class UserService {
	private final Log LOG = LogFactory.getLog(UserService.class);
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional
	public void saveTransactional(List<User> users) {
		users.stream()
		.peek(user -> LOG.info("Usuario insertado: "+ user))
		//.forEach(user -> userRepository.save(user));
		.forEach(userRepository::save);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
}
