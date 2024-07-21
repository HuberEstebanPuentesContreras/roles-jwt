package com.example.esteban.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.esteban.Entity.Usuario;
import com.example.esteban.IService.UsuarioIService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("api/security/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioIService service;
		
	@GetMapping("{email}")
    public ResponseEntity<?> findByCedula(@PathVariable String email) {
    	Optional<Usuario> optionalUsuario = service.findByEmail(email);
    	if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            Map<String, Object> response = new HashMap<>();
            response.put("id", usuario.getId());
            response.put("nombre", usuario.getNombre());
            response.put("apellido", usuario.getApellido());
            response.put("TipoDocumento", usuario.getTipoDocumento());
            response.put("NumeroDocumento", usuario.getNumeroDocumento());
            response.put("Edad", usuario.getEdad());
            response.put("Telefono", usuario.getTelefono());
            response.put("email", usuario.getEmail());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@PutMapping("{Id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Usuario update(@PathVariable String email, @RequestBody Usuario usuario) {
		Optional<Usuario> op = service.findByEmail(email);
		
		if(!op.isEmpty()) {
			Usuario usuarioUpdate = op.get();
			usuarioUpdate.setNombre(usuario.getNombre());
			usuarioUpdate.setApellido(usuario.getApellido());
			usuarioUpdate.setEdad(usuario.getEdad());
			usuarioUpdate.setTipoDocumento(usuario.getTipoDocumento());
			usuarioUpdate.setTelefono(usuario.getTelefono());
			return service.save(usuarioUpdate);
		}
		
		return usuario;
	}
	
	@DeleteMapping("{Id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer Id) {
		service.delete(Id);
	}
}
