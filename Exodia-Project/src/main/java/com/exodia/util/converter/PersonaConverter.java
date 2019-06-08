package com.exodia.util.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.exodia.entity.PersonaEntity;
import com.exodia.util.validator.GenericValidator;
import com.exodia.vo.PersonaVO;


@Component
public class PersonaConverter {
	
	@Autowired
	private GenericValidator<PersonaEntity> genericvalidator;
	
	public PersonaEntity modelToEntity(com.exodia.vo.PersonaVO personaVO) throws BindException {
		PersonaEntity personaEntity =null;
		if(personaVO != null) {
			personaEntity= new PersonaEntity();
			personaEntity.setId(personaVO.getId());
			personaEntity.setNombres(personaVO.getNombres());
			personaEntity.setApellidos(personaVO.getApellidos());
			personaEntity.setTelefono(personaVO.getTelefono());
			personaEntity.setCorreo(personaVO.getCorreo());
		}
		genericvalidator.validate(personaEntity);
		return personaEntity;
	}
	
	public PersonaVO entityToModel(PersonaEntity personaEntity) {
		PersonaVO personaVO=null;
		if(personaEntity !=null) {
			personaVO = new PersonaVO();
			personaVO.setId(personaEntity.getId());
			personaVO.setNombres(personaEntity.getNombres());
			personaVO.setApellidos(personaEntity.getApellidos());
			personaVO.setTelefono(personaEntity.getTelefono());
			personaVO.setCorreo(personaEntity.getCorreo());
		}
		return personaVO;
	}

}
