package com.example.esteban.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.Course;
import com.example.esteban.IRepository.CourseIRepository;
import com.example.esteban.IService.CourseIService;

@Service
public class CourseService implements CourseIService{

	@Autowired
	private CourseIRepository repository;
	
	@Override
	public List<Course> all() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Course> findById(Integer id) {
		return this.repository.findById(id);
	}

	@Override
	public Course save(Course course) {
		return this.repository.save(course);
	}

	@Override
	public void delete(Integer id) {
		this.repository.deleteById(id);
	}

	
}
