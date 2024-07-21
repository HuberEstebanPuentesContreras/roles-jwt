package com.example.esteban.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.Teacher;
import com.example.esteban.IRepository.TeacherIRepository;
import com.example.esteban.IService.TeacherIService;

@Service
public class TeacherService implements TeacherIService{
	
	@Autowired
	private TeacherIRepository repository;
	
	@Override
	public List<Teacher> all() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Teacher> findById(Integer id) {
		return this.repository.findById(id);
	}

	@Override
	public Teacher save(Teacher teacher) {
		return this.repository.save(teacher);
	}

	@Override
	public void delete(Integer id) {
		this.repository.deleteById(id);
	}

}
