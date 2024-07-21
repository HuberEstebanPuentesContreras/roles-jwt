package com.example.esteban.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.User;
import com.example.esteban.IRepository.AssingRoleIRepository;
import com.example.esteban.IService.AssingRoleIService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AssingRoleService implements AssingRoleIService{

	@Autowired
    private AssingRoleIRepository assingRoleIRepository;

	@Override
	public List<User> all() {
		return this.assingRoleIRepository.findAll();
	}
	
	@Override
	public Optional<User> findByOptional(String documentNumber) {
		return this.assingRoleIRepository.findBydocumentNumber(documentNumber);
	}

	@Override
	public User save(User user) {
		return this.assingRoleIRepository.save(user);
	}
	
}
