package com.example.esteban.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.Cursos;
import com.example.esteban.IRepository.CursoIRepository;
import com.example.esteban.IService.CursoIService;

@Service
public class CursoService implements CursoIService{

	@Autowired
	private CursoIRepository repository;
	
	@Override
	public List<Cursos> all() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Cursos> findById(Integer Id) {
		return this.repository.findById(Id);
	}

	@Override
	public Cursos save(Cursos cursos) {
		return this.repository.save(cursos);
	}

	@Override
	public void delete(Integer Id) {
		this.repository.deleteById(Id);
	}

	
}
