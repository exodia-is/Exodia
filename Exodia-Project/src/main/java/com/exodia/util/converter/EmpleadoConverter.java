package com.exodia.util.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;

import com.exodia.entity.EmpleadoEntity;
import com.exodia.util.validator.GenericValidator;
import com.exodia.vo.EmpleadoVO;

public class EmpleadoConverter {

	@Autowired
	private GenericValidator<EmpleadoEntity> genericValidator;
	
	public EmpleadoEntity modalToEntity(EmpleadoVO empleadoVO) throws BindException {
		EmpleadoEntity empleadoEntity = null;
		if(empleadoVO != null) {
			empleadoEntity = new EmpleadoEntity();
			empleadoEntity.setId(empleadoVO.getId());
			empleadoEntity.setNombres(empleadoVO.getNombres());
			empleadoEntity.setApellidos(empleadoVO.getApellidos());
//			empleadoEntity.setTelefono(empleadoVO.getTelefono());
//			empleadoEntity.setCorreo(empleadoVO.getCorreo());
		
			
		}
		genericValidator.validate(empleadoEntity);
		return empleadoEntity;
	}
	
	
	public EmpleadoVO entityToModel(EmpleadoEntity  empleadoEntity) {
		EmpleadoVO empleadoVO = null;
		if(empleadoEntity != null) {
			empleadoVO = new EmpleadoVO();
			empleadoVO.setId(empleadoEntity.getId());
			empleadoVO.setNombres(empleadoEntity.getNombres());
			empleadoVO.setApellidos(empleadoEntity.getApellidos());
//			empleadoVO.setTelefono(empleadoEntity.getTelefono());
//			empleadoVO.setCorreo(empleadoEntity.getCorreo());
			
			
		}		
		return empleadoVO;
	}

}
