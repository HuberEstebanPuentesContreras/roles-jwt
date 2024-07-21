package com.example.esteban.IService;

import java.util.List;
import java.util.Optional;

import com.example.esteban.Entity.Specialty;

public interface SpecialtyIService {
	
	public List<Specialty>all ();
	
	public Optional<Specialty> findById(Integer id);
	
	public Specialty save(Specialty specialty);
	
	public void delete(Integer id);

}
