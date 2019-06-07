package com.exodia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Employee")
public class EmpleadoEntity implements Serializable  {

	private static final long serialVersionUID = 4804230507912457413L;

	@Id
	@Column(name="employee_id", nullable=false, length=15)
	private Long id;
	
	@NotEmpty(message="El campo nombres no puede ser vacio.")
	@Size(min=3, max=250, message="Tamaño del campo nombres no es válido.")
	@Column(name="first_name", nullable=false, length=70)
	private String nombres;
	
	@NotEmpty(message="El campo apellidos no puede ser vacio.")
	@Size(min=3, max=250, message="Tamaño del campo apellidos no es válido.")
	@Column(name="last_name", nullable=false, length=100)
	private String apellidos;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}
