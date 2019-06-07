package com.exodia.util.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;

public class EmpleadoConverter {

	@Autowired
	private GenericValidator<PersonaEntity> genericValidator;
	
	public PersonaEntity modalToEntity(PersonaVO personaVO) throws BindException {
		PersonaEntity personaEntity = null;
		if(personaVO != null) {
			personaEntity = new PersonaEntity();
			personaEntity.setId(personaVO.getId());
			personaEntity.setNombres(personaVO.getNombres());
			personaEntity.setApellidos(personaVO.getApellidos());
			personaEntity.setTelefono(personaVO.getTelefono());
			personaEntity.setCorreo(personaVO.getCorreo());
		
			
		}
		genericValidator.validate(personaEntity);
		return personaEntity;
	}
	
	
	public PersonaVO entityToModel(PersonaEntity  personaEntity) {
		PersonaVO personaVO = null;
		if(personaEntity != null) {
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
