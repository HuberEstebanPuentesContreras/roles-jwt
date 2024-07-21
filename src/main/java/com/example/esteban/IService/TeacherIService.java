package com.example.esteban.IService;

import java.util.List;
import java.util.Optional;

import com.example.esteban.Entity.Profesor;

public interface ProfesorIService {

	public List<Profesor>all ();
	
	public Optional<Profesor> findById(Integer Id);
	
	public Profesor save(Profesor profesor);
	
	public void delete(Integer Id);
}
