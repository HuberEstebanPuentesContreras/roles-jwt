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

import com.example.esteban.Entity.Profesor;
import com.example.esteban.IService.ProfesorIService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("api/security/profesor")
public class ProfesorController {

	@Autowired
	private ProfesorIService service;
	
	@GetMapping
	public List<Profesor> all(){
		return service.all();
	}
	
	@GetMapping("{Id}")
	public Optional<Profesor> show(@PathVariable Integer Id){
		return service.findById(Id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Profesor save(@RequestBody Profesor profesor) {
		return service.save(profesor);
	}
	
	@PutMapping("{Id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Profesor update(@PathVariable Integer Id, @RequestBody Profesor profesor) {
		Optional<Profesor> op = service.findById(Id);
		
		if(!op.isEmpty()) {
			Profesor profesorUpdate = op.get();
			profesorUpdate.setEspecialidad(profesor.getEspecialidad());
			profesorUpdate.setUsuario(profesor.getUsuario());
			return service.save(profesorUpdate);
		}
		
		return profesor;
	}
	
	@DeleteMapping("{Id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer Id) {
		service.delete(Id);
	}
	
}
