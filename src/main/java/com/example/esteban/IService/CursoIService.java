package com.example.esteban.IService;

import java.util.List;
import java.util.Optional;

import com.example.esteban.Entity.Cursos;

public interface CursoIService {

	public List<Cursos>all ();
	
	public Optional<Cursos> findById(Integer Id);
	
	public Cursos save(Cursos cursos);
	
	public void delete(Integer Id);

}
