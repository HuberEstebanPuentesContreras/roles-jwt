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

import com.example.esteban.Entity.User;
import com.example.esteban.Service.UserService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("api/security/user")
public class UserController {

	@Autowired
	private UserService service;
		
	@GetMapping("{email}")
    public ResponseEntity<?> findByCedula(@PathVariable String email) {
    	Optional<User> optionalUser = service.findByEmail(email);
    	if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("nombre", user.getName());
            response.put("apellido", user.getLastName());
            response.put("TipoDocumento", user.getDocumentType());
            response.put("NumeroDocumento", user.getDocumentNumber());
            response.put("Edad", user.getAge());
            response.put("Telefono", user.getPhoneNumber());
            response.put("email", user.getEmail());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User update(@PathVariable String email, @RequestBody User user) {
		Optional<User> op = service.findByEmail(email);
		
		if(!op.isEmpty()) {
			User userUpdate = op.get();
			userUpdate.setName(user.getName());
			userUpdate.setLastName(user.getLastName());
			userUpdate.setAge(user.getAge());
			userUpdate.setDocumentType(user.getDocumentType());
			userUpdate.setPhoneNumber(user.getPhoneNumber());
			return service.save(userUpdate);
		}
		
		return user;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
