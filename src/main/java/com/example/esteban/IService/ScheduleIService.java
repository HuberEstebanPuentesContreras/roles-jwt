package com.example.esteban.IService;

import java.util.List;
import java.util.Optional;

import com.example.esteban.Entity.Schedule;


public interface ScheduleIService {

	public List<Schedule>all ();
	
	public Optional<Schedule> findById(Integer id);
	
}
