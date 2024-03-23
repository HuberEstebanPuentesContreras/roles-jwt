package com.example.esteban.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.esteban.Service.HorarioService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("api/security/horario")
public class HorarioController {

	@Autowired
    private HorarioService horarioService;
    
    @PostMapping("/generar")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void generarHorarioAutomaticamente() {
        horarioService.generarHorarioAutomaticamente();
    }
    
}
