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

import com.example.esteban.Entity.Specialty;
import com.example.esteban.Service.SpecialtyService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("api/security/specialty")
public class SpecialtyController {
	
	@Autowired
	private SpecialtyService service;
	
	@GetMapping
	public List<Specialty> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Specialty> show(@PathVariable Integer id){
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Specialty save(@RequestBody Specialty specialty) {
		return service.save(specialty);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Specialty update(@PathVariable Integer id, @RequestBody Specialty specialty) {
		Optional<Specialty> op = service.findById(id);
		
		if(!op.isEmpty()) {
			Specialty specialtyUpdate = op.get();
			specialtyUpdate.setCode(specialty.getCode());
			specialtyUpdate.setName(specialty.getName());
			specialtyUpdate.setDescription(specialty.getDescription());
			return service.save(specialtyUpdate);
		}
		
		return specialty;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
