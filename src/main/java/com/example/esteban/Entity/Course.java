package com.example.esteban.Entity;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
@Table(name="course")
public class Course implements Serializable{
	
	private final static long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "code", length = 4, nullable = false, unique = true)
	private String code;

	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;
	
	@Column(name = "credits", length = 50, nullable = false)
	private String credits;
	
	@Column(name = "description", length = 100, nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "specialty_id", nullable = false)
    private Specialty specialty;
	
	public Course() {
    }
	
}
