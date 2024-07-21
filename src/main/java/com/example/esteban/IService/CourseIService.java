package com.example.esteban.IService;

import java.util.List;
import java.util.Optional;

import com.example.esteban.Entity.Course;

public interface CourseIService {

	public List<Course>all ();
	
	public Optional<Course> findById(Integer id);
	
	public Course save(Course course);
	
	public void delete(Integer id);

}
