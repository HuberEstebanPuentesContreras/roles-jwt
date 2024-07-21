package com.example.esteban.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.esteban.Entity.Schedule;
import com.example.esteban.Service.ScheduleService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("api/security/schedule/")
public class ScheduleController {

	@Autowired
    private ScheduleService scheduleService;
    
	@GetMapping("get")
	public List<Schedule> all(){
		return scheduleService.all();
	}
	
	@GetMapping("getId/{id}")
	public Optional<Schedule> show(@PathVariable Integer id){
		return scheduleService.findById(id);
	}
	
    @PostMapping("/generate")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void automaticallyGenerateSchedule() {
        scheduleService.automaticallyGenerateSchedule();
    }
    
}
