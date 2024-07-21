package com.example.esteban.IService;

import java.util.List;
import java.util.Optional;

import com.example.esteban.Entity.Teacher;

public interface TeacherIService {

	public List<Teacher>all ();
	
	public Optional<Teacher> findById(Integer id);
	
	public Teacher save(Teacher teacher);
	
	public void delete(Integer id);
}
