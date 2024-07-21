package com.example.esteban.IService;

import java.util.List;
import java.util.Optional;

import com.example.esteban.Entity.User;

public interface AssingRoleIService {

	public List<User> all();
	
	
	Optional<User> findByOptional(String documentNumber);
	
	public User save(User user);

	
}
