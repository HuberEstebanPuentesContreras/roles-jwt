package com.example.esteban.IRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esteban.Entity.User;

public interface AssingRoleIRepository extends JpaRepository<User,Integer>{
	Optional<User> findBydocumentNumber(String documentNumber);
}

