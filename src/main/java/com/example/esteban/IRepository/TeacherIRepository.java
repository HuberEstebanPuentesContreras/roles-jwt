package com.example.esteban.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esteban.Entity.Teacher;

public interface TeacherIRepository extends JpaRepository<Teacher,Integer>{

}
