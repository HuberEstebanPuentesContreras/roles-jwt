package com.example.esteban.Service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.Cursos;
import com.example.esteban.Entity.Horario;
import com.example.esteban.Entity.Profesor;
import com.example.esteban.IRepository.HorarioIRepository;
import com.example.esteban.IService.CursoIService;
import com.example.esteban.IService.ProfesorIService;

@Service
public class HorarioService {

    @Autowired
    private CursoIService cursoService;

    @Autowired
    private ProfesorIService profesorService;

    @Autowired
    private HorarioIRepository horarioRepository;

    public void generarHorarioAutomaticamente() {
        List<Cursos> cursos = cursoService.all();
        List<Profesor> profesores = profesorService.all();
        Random random = new Random();

        String[] diasSemanaArray = {"LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES"};
        List<String> diasSemana = java.util.Arrays.asList(diasSemanaArray);

        for (Cursos curso : cursos) {
            String diaSemana = diasSemana.get(random.nextInt(diasSemana.size()));
            String horaInicio = null;
            String horaFin = null;

            if (random.nextBoolean()) {
                horaInicio = "07:00";
                horaFin = "10:00";
            } else {
                horaInicio = "18:00";
                horaFin = "21:00";
            }

            for (Profesor profesor : profesores) {
                if (profesor.getEspecialidad() == curso.getEspecialidad()) {
                    Profesor profesorAsignado = profesor;
                    Horario horario = new Horario();
                    horario.setCursos(curso);
                    horario.setProfesor(profesorAsignado);
                    horario.setDia(diaSemana);
                    horario.setHoraInicio(horaInicio);
                    horario.setHoraFin(horaFin);
                    horarioRepository.save(horario);
                    break;
                }
            }
        }
    }
}
