package com.example.esteban.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esteban.Entity.Schedule;

public interface ScheduleIRepository extends JpaRepository<Schedule, Integer>{
	
	boolean existsByDayAndStartTimeAndEndTime(String day, String startTime, String endTime);
	
}
