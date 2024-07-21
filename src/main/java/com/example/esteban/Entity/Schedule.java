package com.example.esteban.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "horario")
public class Horario implements Serializable{
	
	private final static long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
		
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id", nullable = false)
    private Cursos cursos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesor profesor;
    
    @Column(name = "dia", length = 50, nullable = false)
	private String dia;
    
    @Column(name = "hora_inicio", length = 50, nullable = false)
	private String horaInicio;
    
    @Column(name = "hora_fin", length = 50, nullable = false)
	private String horaFin;


}
