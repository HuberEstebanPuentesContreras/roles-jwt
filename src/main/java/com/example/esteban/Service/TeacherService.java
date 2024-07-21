package com.example.esteban.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.Profesor;
import com.example.esteban.IRepository.ProfesorIRepository;
import com.example.esteban.IService.ProfesorIService;

@Service
public class ProfesorService implements ProfesorIService{
	
	@Autowired
	private ProfesorIRepository repository;
	
	@Override
	public List<Profesor> all() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Profesor> findById(Integer Id) {
		return this.repository.findById(Id);
	}

	@Override
	public Profesor save(Profesor profesor) {
		return this.repository.save(profesor);
	}

	@Override
	public void delete(Integer Id) {
		this.repository.deleteById(Id);
	}

}
