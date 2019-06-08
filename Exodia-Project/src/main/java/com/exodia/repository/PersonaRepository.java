package com.exodia.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exodia.entity.PersonaEntity;


@Repository("PersonaRepository")
public interface PersonaRepository  extends JpaRepository<PersonaEntity, Serializable>{

}
