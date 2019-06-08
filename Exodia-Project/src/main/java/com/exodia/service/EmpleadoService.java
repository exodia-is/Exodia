package com.exodia.service;

import java.util.List;

import org.springframework.validation.BindException;

import com.exodia.entity.PersonaEntity;
import com.exodia.vo.PersonaVO;



public interface EmpleadoService {

		List<PersonaEntity>  listAll();
		
		void save(PersonaEntity personaEntity);

		PersonaEntity findById(long id);

		void save(PersonaVO personaVO) throws BindException;
		
		void delete(long id);
		
		void editar(PersonaVO personaVo);
		

}
