package com.exodia.service;

import java.util.List;

import org.springframework.validation.BindException;

import com.exodia.entity.EmpleadoEntity;
import com.exodia.vo.EmpleadoVO;

public interface EmpleadoService {
	
	List<EmpleadoEntity>  listAll();
	
	void save(EmpleadoEntity empleadoEntity);

	EmpleadoEntity findById(long id);

	void save(EmpleadoVO personaVO) throws BindException;

	void delete(Long id);
}
