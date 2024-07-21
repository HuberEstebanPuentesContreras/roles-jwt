package com.example.esteban.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esteban.Entity.Horario;

public interface HorarioIRepository extends JpaRepository<Horario, Integer>{

	boolean existsByDiaAndHoraInicioAndHoraFin(String dia, String horaInicio, String horaFin);
	
}
