package com.example.esteban.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.Course;
import com.example.esteban.Entity.Schedule;
import com.example.esteban.Entity.Teacher;
import com.example.esteban.IRepository.ScheduleIRepository;
import com.example.esteban.IService.CourseIService;
import com.example.esteban.IService.ScheduleIService;
import com.example.esteban.IService.TeacherIService;

@Service
public class ScheduleService implements ScheduleIService{

    @Autowired
    private CourseIService courseIService;

    @Autowired
    private TeacherIService teacherIService;

    @Autowired
    private ScheduleIRepository scheduleIRepository;

    @Override
	public List<Schedule> all() {
		return this.scheduleIRepository.findAll();
	}

	@Override
	public Optional<Schedule> findById(Integer id) {
		return this.scheduleIRepository.findById(id);
	}
    
    
    //Metodo para generar horarios automaticamente
    public void automaticallyGenerateSchedule() {
        List<Course> courses = courseIService.all();
        List<Teacher> teachers = teacherIService.all();
        Random random = new Random();

        String[] daysOfWeekArray = {"LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES"};
        List<String> daysOfWeek = java.util.Arrays.asList(daysOfWeekArray);

        //Ciclo para pasar por cada curso para asignar horario
        for (Course course : courses) {
        	//Selecciona dia aleatorio de la semana
            String day = daysOfWeek.get(random.nextInt(daysOfWeek.size()));
            String startTime = null;
            String endTime = null;

            //Determina aleatoriamente la hora de incio y fin
            if (random.nextBoolean()) {
            	startTime = "07:00";
                endTime = "10:00";
            } else {
            	startTime = "18:00";
                endTime = "21:00";
            }
            
            //Ciclo para asignar profesores a cada curso
            for (Teacher teacher : teachers) {
            	//Condicional para verificar si la especialidad del profesor coincide con la del curso
                if (teacher.getSpecialty() == course.getSpecialty()) {
                    Teacher assingTeacher = teacher;
                    Schedule schedule = new Schedule();
                    schedule.setCourse(course);
                    schedule.setTeacher(assingTeacher);
                    schedule.setDay(day);
                    schedule.setStartTime(startTime);
                    schedule.setEndTime(endTime);
                    scheduleIRepository.save(schedule);
                    break;
                }
            }
        }
    }
}
