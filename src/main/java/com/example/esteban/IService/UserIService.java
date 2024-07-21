package com.example.esteban.IService;

import java.util.Optional;

import com.example.esteban.Entity.Usuario;


public interface UsuarioIService {
	
	Optional<Usuario> findByEmail(String email);
	
	public Usuario save(Usuario usuario);
	
	public void delete(Integer Id);

}
