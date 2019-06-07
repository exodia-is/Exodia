package com.exodia.rest;

import java.util.List;

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

import com.exodia.entity.EmpleadoEntity;
import com.exodia.service.EmpleadoService;

@RestController("EmpleadoWS")
@RequestMapping("empledo")
public class EmpleadoWS {
 
	@Autowired
	@Qualifier("PersonaServiceImpl")
	private EmpleadoService empleadoService;
	
	
	@GetMapping("/listar")
	public List<EmpleadoEntity> listAll(){
		return empleadoService.listAll();
	}
	
	
	@GetMapping("/persona/{id}")
	public EmpleadoEntity findById(@PathVariable long id) {
		return  empleadoService.findById(id);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public void crear(@RequestBody EmpleadoEntity persona) {
		empleadoService.save(persona);
	}
	
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void update( @PathVariable long id, @RequestBody EmpleadoEntity persona) {
		persona.setId(id);
		empleadoService.save(persona);
	}
}
