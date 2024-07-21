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

import com.example.esteban.Entity.Course;
import com.example.esteban.Service.CourseService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("api/security/course")
public class CourseController {

	@Autowired
	private CourseService service;
	
	@GetMapping
	public List<Course> all(){
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Course> show(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Course save(@RequestBody Course course) {
		return service.save(course);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Course update(@PathVariable Integer id, @RequestBody Course course) {
		Optional<Course> op = service.findById(id);
		
		if(!op.isEmpty()) {
			Course courseUpdate = op.get();
			courseUpdate.setCode(course.getCode());
			courseUpdate.setName(course.getName());
			courseUpdate.setCredits(course.getCredits());
			courseUpdate.setDescription(course.getDescription());
			return service.save(courseUpdate);
		}
		
		return course;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
