package com.example.esteban.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.esteban.Entity.Teacher;
import com.example.esteban.Service.TeacherService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("api/security/teacher")
public class TeacherController {

	@Autowired
	private TeacherService service;
	
	@GetMapping
	public List<Teacher> all(){
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Teacher> show(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Teacher save(@RequestBody Teacher teacher) {
		return service.save(teacher);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Teacher update(@PathVariable Integer id, @RequestBody Teacher teacher) {
		Optional<Teacher> op = service.findById(id);
		
		if(!op.isEmpty()) {
			Teacher teacherUpdate = op.get();
			teacherUpdate.setSpecialty(teacher.getSpecialty());
			teacherUpdate.setUser(teacher.getUser());
			return service.save(teacherUpdate);
		}
		
		return teacher;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
