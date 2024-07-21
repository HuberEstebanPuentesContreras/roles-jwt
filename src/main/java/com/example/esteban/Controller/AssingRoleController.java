package com.example.esteban.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.esteban.Entity.User;
import com.example.esteban.Service.AssingRoleService;


@RestController
@RequestMapping("/api/security/assingrole")
@CrossOrigin(origins = {"*"})
public class AssingRoleController {

	@Autowired
    private AssingRoleService service;

	@GetMapping
	public List<User> all() {
		return service.all();
	}
	
    @GetMapping("{documentNumber}")
    public ResponseEntity<?> findByCedula(@PathVariable String documentNumber) {
    	Optional<User> optionalUser = service.findByOptional(documentNumber);
    	if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("nombre", user.getName());
            response.put("apellido", user.getLastName());
            response.put("Numero Documento", user.getDocumentNumber());
            response.put("role", user.getRole());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("{documentNumber}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User update(@PathVariable String documentNumber, @RequestBody User user) {
    	Optional<User> op = service.findByOptional(documentNumber);
		
		if (!op.isEmpty()) {
			User roleUpdate = op.get();
			roleUpdate.setRole(user.getRole());
			return service.save(roleUpdate);
		}
		
		return user;
	}

    

}
