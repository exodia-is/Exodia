package com.exodia.empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.exodia.service.EmpleadoService;
import com.exodia.vo.PersonaVO;

@Controller("CreaController")
@RequestMapping("/exodia")
public class CreaController {

	private static final String VIEW = "crear";
	@Autowired
	private EmpleadoService personaService;

	@GetMapping("/crear")
	public ModelAndView showCrear() {
		ModelAndView view = getView();
		view.addObject("persona", new PersonaVO());
		return view;

	}

	@PostMapping("/insertar")
	public Object insertar(@ModelAttribute("persona") PersonaVO personaVO) {
		Object retorno = null;
		try {
			personaService.save(personaVO);
			retorno = new RedirectView("/exodia/listar");
		} catch (BindException e) {
			ModelAndView view = getView();
			retorno = view;
			view.addObject("persona", personaVO);
			view.addObject("validationError", e.getObjectName().toString());
			retorno = view;

		}
		return retorno;

	}

	private ModelAndView getView() {
		return new ModelAndView(VIEW);
	}

}