package com.example.esteban.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esteban.Entity.Specialty;

public interface SpecialtyIRepository extends JpaRepository<Specialty, Integer>{

}
