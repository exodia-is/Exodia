package com.exodia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindException;

import com.exodia.entity.EmpleadoEntity;
import com.exodia.repository.EmpleadoRepository;
import com.exodia.service.EmpleadoService;
import com.exodia.util.converter.EmpleadoConverter;
import com.exodia.vo.EmpleadoVO;

public class EmpleadoServiceImlp implements EmpleadoService {
	
	@Autowired
	@Qualifier("PersonaRepository")
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private EmpleadoConverter personaConverter;

	@Override
	public List<EmpleadoEntity> listAll() {
		return empleadoRepository.findAll();

	}

	@Override
	public EmpleadoEntity findById(long id) {
		return empleadoRepository.findById(id).orElse(null);
	}

	@Override
	public void save(EmpleadoEntity personaEntity) {
		empleadoRepository.save(personaEntity);
	}

	@Override
	public void save(EmpleadoVO personaVO) throws BindException {
		empleadoRepository.save(personaConverter.modalToEntity(personaVO));
		
	}

	@Override
	public void delete(Long id) {
		empleadoRepository.deleteById(id);
		
	}
}
