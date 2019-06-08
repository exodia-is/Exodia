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
@Table(name="persona")
public class PersonaEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4804230507912457413L;

	@Id
	@Column(name="id", nullable=false, length=250)
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message="El campo nombres no puede ser vacio.")
	@Size(min=3, max=250, message="Tamaño del campo nombres no es válido.")
	@Column(name="nombres", nullable=false, length=250)
	private String nombres;
	
	@NotEmpty(message="El campo apellido no puede ser vacio.")
	@Size(min=3, max=250, message="Tamaño del campo apellido no es válido.")
	@Column(name="apellidos", nullable=false, length=250)
	private String apellidos;
	
	@NotEmpty(message="El campo telefono no puede ser vacio.")
	@Size(min=3, max=250, message="Tamaño del campo telefono no es válido.")
	@Column(name="telefono", nullable=false, length=15)
	private String telefono;
	
	@NotEmpty(message="El campo correo no puede ser vacio.")
	@Email(message="El formato del correo no es valido.")
	@Column(name="correo", nullable=true, length=50)
	private String correo;
	
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	

}
