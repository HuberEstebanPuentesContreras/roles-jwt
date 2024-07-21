package com.example.esteban.IService;

import java.util.Optional;

import com.example.esteban.Entity.User;


public interface UserIService {
	
	Optional<User> findByEmail(String email);
	
	public User save(User user);
	
	public void delete(Integer id);

}
