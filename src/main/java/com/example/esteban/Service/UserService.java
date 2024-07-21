package com.example.esteban.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.User;
import com.example.esteban.IRepository.UserIRepository;
import com.example.esteban.IService.UserIService;

@Service
public class UserService implements UserIService{

	@Autowired
	private UserIRepository repository;
	
	@Override
	public Optional<User> findByEmail(String email) {
		return this.repository.findByEmail(email);
	}
	
	@Override
	public User save(User user) {
		return this.repository.save(user);
	}

	@Override
	public void delete(Integer id) {
		this.repository.deleteById(id);
	}

	

	
}
