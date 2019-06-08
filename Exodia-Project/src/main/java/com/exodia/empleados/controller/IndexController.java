package com.exodia.empleados.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("IndexController")
@RequestMapping("/exodia")
public class IndexController {
	
	private static final String VIEW = "index";
	
	@GetMapping("/index")
	public ModelAndView showIndex() {
		ModelAndView view =  new ModelAndView(VIEW);	
		return view;
		
	}

}
