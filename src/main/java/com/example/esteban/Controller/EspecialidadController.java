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

import com.example.esteban.Entity.Especialidad;
import com.example.esteban.IService.EspecialidadIService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("api/security/especialidad")
public class EspecialidadController {
	
	@Autowired
	private EspecialidadIService service;
	
	@GetMapping
	public List<Especialidad> all() {
		return service.all();
	}
	
	@GetMapping("{Id}")
	public Optional<Especialidad> show(@PathVariable Integer Id){
		return service.findById(Id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Especialidad save(@RequestBody Especialidad especialidad) {
		return service.save(especialidad);
	}
	
	@PutMapping("{Id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Especialidad update(@PathVariable Integer Id, @RequestBody Especialidad especialidad) {
		Optional<Especialidad> op = service.findById(Id);
		
		if(!op.isEmpty()) {
			Especialidad especialidadUpdate = op.get();
			especialidadUpdate.setCodigo(especialidad.getCodigo());
			especialidadUpdate.setNombre(especialidad.getNombre());
			especialidadUpdate.setDescripcion(especialidad.getDescripcion());
			return service.save(especialidadUpdate);
		}
		
		return especialidad;
	}
	
	@DeleteMapping("{Id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer Id) {
		service.delete(Id);
	}
}
