package com.example.esteban.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "especialidad")
public class Especialidad implements Serializable{
	
	private final static long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "codigo", length = 4, nullable = false, unique = true)
	private String Codigo;
	
	@Column(name = "nombre", length = 50, nullable = false, unique = true)
	private String Nombre;
	
	@Column(name = "descripcion", length = 100, nullable = false)
	private String Descripcion;

	public Especialidad() {
    }
}
