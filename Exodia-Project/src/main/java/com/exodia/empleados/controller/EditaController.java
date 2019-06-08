package com.exodia.empleados.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.exodia.service.EmpleadoService;
import com.exodia.vo.PersonaVO;


@Controller("EditaController")
@RequestMapping("/exodia")
public class EditaController {
	
	private static final String VIEW = "editar";
	
	@Autowired
	@Qualifier("PersonaServiceImpl")
	private EmpleadoService personaService;
	
	@GetMapping("/editar")
	public ModelAndView showeditar(@RequestParam(name="id", required = true) long id) {
		ModelAndView view = getView();
		view.addObject("persona", personaService.findById(id));
		return view;
	}
	
	@PostMapping("/actualizar")
	public Object insertar( @ModelAttribute("persona") PersonaVO personaVO) {
		Object retorno = null;
		try {
			personaService.save(personaVO);
			retorno = new RedirectView("/exodia/listar");
		} catch (BindException e) {
			ModelAndView view =  getView();
			retorno = view;
			view.addObject("persona", personaVO);
			view.addObject("validationError", e.getObjectName().toString());
			retorno = view;
			
			
		}
		return  retorno;
		
	}

	private ModelAndView getView() {
		return new ModelAndView(VIEW);
	}

}
