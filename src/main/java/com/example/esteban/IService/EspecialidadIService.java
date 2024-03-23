package com.example.esteban.IService;

import java.util.List;
import java.util.Optional;

import com.example.esteban.Entity.Especialidad;

public interface EspecialidadIService {
	
	public List<Especialidad>all ();
	
	public Optional<Especialidad> findById(Integer Id);
	
	public Especialidad save(Especialidad especialidad);
	
	public void delete(Integer Id);

}
