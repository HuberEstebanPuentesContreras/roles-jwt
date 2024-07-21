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

import com.example.esteban.Entity.Cursos;
import com.example.esteban.IService.CursoIService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("api/security/cursos")
public class CursoController {

	@Autowired
	private CursoIService service;
	
	@GetMapping
	public List<Cursos> all(){
		return service.all();
	}
	
	@GetMapping("{Id}")
	public Optional<Cursos> show(@PathVariable Integer Id){
		return service.findById(Id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cursos save(@RequestBody Cursos cursos) {
		return service.save(cursos);
	}
	
	@PutMapping("{Id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cursos update(@PathVariable Integer Id, @RequestBody Cursos cursos) {
		Optional<Cursos> op = service.findById(Id);
		
		if(!op.isEmpty()) {
			Cursos cursosUpdate = op.get();
			cursosUpdate.setCodigo(cursos.getCodigo());
			cursosUpdate.setNombre(cursos.getNombre());
			cursosUpdate.setCreditos(cursos.getCreditos());
			cursosUpdate.setDescripcion(cursos.getDescripcion());
			return service.save(cursosUpdate);
		}
		
		return cursos;
	}
	
	@DeleteMapping("{Id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer Id) {
		service.delete(Id);
	}

}
