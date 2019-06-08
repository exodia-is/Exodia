package com.exodia.empleados.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("BuscaController")
@RequestMapping("/exodia")
public class BuscaController {
	
	private static final String VIEW = "buscar";
	
	@GetMapping("/buscar")
	public ModelAndView showIndex() {
		ModelAndView view =  new ModelAndView(VIEW);
		return view;
		
	}

}
