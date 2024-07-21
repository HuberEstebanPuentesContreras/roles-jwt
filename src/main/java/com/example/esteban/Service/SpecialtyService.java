package com.example.esteban.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.Specialty;
import com.example.esteban.IRepository.SpecialtyIRepository;
import com.example.esteban.IService.SpecialtyIService;

@Service
public class SpecialtyService implements SpecialtyIService{

	@Autowired
	private SpecialtyIRepository repository;
	
	@Override
	public List<Specialty> all() {
		return this.repository.findAll();		
	}
	
	@Override
	public Optional<Specialty> findById(Integer id) {
		return this.repository.findById(id);
	}
	
	@Override
	public Specialty save(Specialty specialty) {
		return this.repository.save(specialty);
	}
	
	@Override
	public void delete(Integer id) {
		this.repository.deleteById(id);
	}
	
	
}
