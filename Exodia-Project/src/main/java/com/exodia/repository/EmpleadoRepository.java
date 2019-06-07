package com.exodia.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exodia.entity.EmpleadoEntity;

@Repository("EmpleadoRepository")
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Serializable> {

}
