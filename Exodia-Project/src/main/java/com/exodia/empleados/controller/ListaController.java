package com.exodia.empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exodia.service.EmpleadoService;

@Controller("ListarController")
@RequestMapping("/exodia")
public class ListaController {

	private static final String VIEW = "listar";

	@Autowired
	@Qualifier("PersonaServiceImpl")
	private EmpleadoService personaService;

	@GetMapping("/listar")
	public ModelAndView showListar() {
		ModelAndView view = new ModelAndView(VIEW);
		view.addObject("personas", personaService.listAll());
		return view;
	}

	/*
	 * @PostMapping("/showDeleteModal") public ModelAndView
	 * showDeleteModal(@ModelAttribute("persona") PersonaVO personaVO) {
	 * ModelAndView view = new ModelAndView(VIEW);
	 * view.addObject("personaSeleccionada", personaVO); return view; }
	 * 
	 * @DeleteMapping("/crud/persona/{id}") public void delete(@PathVariable Long id
	 * ) { personaService.delete(id); }
	 */

	@GetMapping("/persona/eliminar")
	public ModelAndView delete(@RequestParam(name = "id", required = true) Long id) {
		personaService.delete(id);
		return showListar();
	}

}
