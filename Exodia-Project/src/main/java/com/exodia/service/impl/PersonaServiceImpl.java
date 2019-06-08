package com.exodia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;

import com.exodia.entity.PersonaEntity;
import com.exodia.repository.PersonaRepository;
import com.exodia.service.EmpleadoService;
import com.exodia.util.converter.PersonaConverter;
import com.exodia.vo.PersonaVO;

@Service("PersonaServiceImpl")
public class PersonaServiceImpl implements EmpleadoService {
	@Autowired
	@Qualifier("PersonaRepository")
	private PersonaRepository personaRepository;

	@Autowired
	private PersonaConverter personaConverter;

	@Override
	public List<PersonaEntity> listAll() {
		return personaRepository.findAll();

	}

	@Override
	public PersonaEntity findById(long id) {
		return personaRepository.findById(id).orElse(null);
	}

	@Override
	public void save(PersonaEntity personaEntity) {
		personaRepository.save(personaEntity);
	}

	@Override
	public void save(PersonaVO personaVO) throws BindException {
		personaRepository.save(personaConverter.modelToEntity(personaVO));
	}

	@Override
	public void delete(long id) {
		personaRepository.deleteById(id);

	}

	@Override
	public void editar(PersonaVO personaVo) {

	}

}
