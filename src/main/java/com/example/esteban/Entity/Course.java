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
@Table(name="cursos")
public class Cursos implements Serializable{
	
	private final static long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "codigo", length = 4, nullable = false, unique = true)
	private String Codigo;

	@Column(name = "nombre", length = 50, nullable = false, unique = true)
	private String Nombre;
	
	@Column(name = "creditos", length = 50, nullable = false)
	private String Creditos;
	
	@Column(name = "descripcion", length = 100, nullable = false)
	private String Descripcion;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;
	
	public Cursos() {
    }
	
}
