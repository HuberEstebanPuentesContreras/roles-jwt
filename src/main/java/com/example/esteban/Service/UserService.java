package com.example.esteban.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.Usuario;
import com.example.esteban.IRepository.UsuarioIRepository;
import com.example.esteban.IService.UsuarioIService;

@Service
public class UsuarioService implements UsuarioIService{

	@Autowired
	private UsuarioIRepository repository;
	
	@Override
	public Optional<Usuario> findByEmail(String email) {
		return this.repository.findByEmail(email);
	}
	
	@Override
	public Usuario save(Usuario usuario) {
		return this.repository.save(usuario);
	}

	@Override
	public void delete(Integer Id) {
		this.repository.deleteById(Id);
	}

	

	
}
