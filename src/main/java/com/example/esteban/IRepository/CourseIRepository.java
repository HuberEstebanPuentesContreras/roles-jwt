package com.example.esteban.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esteban.Entity.Course;

public interface CourseIRepository extends JpaRepository<Course,Integer>{

}
