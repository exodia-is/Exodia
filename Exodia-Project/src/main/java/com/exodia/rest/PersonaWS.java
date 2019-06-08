package com.exodia.rest;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exodia.entity.PersonaEntity;
import com.exodia.service.EmpleadoService;



@RestController("PersonaWS")
@RequestMapping("/persona-service")
public class PersonaWS {
	
	@Autowired
	@Qualifier("PersonaServiceImpl")
	private EmpleadoService personaService;
	
	
	@GetMapping("/listar")
	public List<PersonaEntity> listAll(){
		return personaService.listAll();
	}
	
	
	@GetMapping("/persona/{id}")
	public PersonaEntity findById(@PathVariable long id) {
		return  personaService.findById(id);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public void crear(@RequestBody PersonaEntity persona) {
		personaService.save(persona);
	}
	
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void update( @PathVariable long id, @RequestBody PersonaEntity persona) {
		persona.setId(id);
		personaService.save(persona);
	}

}
