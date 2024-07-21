package com.example.esteban.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.Especialidad;
import com.example.esteban.IRepository.EspecialidadIRepository;
import com.example.esteban.IService.EspecialidadIService;

@Service
public class EspecialidadService implements EspecialidadIService{

	@Autowired
	private EspecialidadIRepository repository;
	
	@Override
	public List<Especialidad> all() {
		return this.repository.findAll();		
	}
	
	@Override
	public Optional<Especialidad> findById(Integer Id) {
		return this.repository.findById(Id);
	}
	
	@Override
	public Especialidad save(Especialidad especialidad) {
		return this.repository.save(especialidad);
	}
	
	@Override
	public void delete(Integer Id) {
		this.repository.deleteById(Id);
	}
	
	
}
