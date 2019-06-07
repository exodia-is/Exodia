package com.exodia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Contact")
public class ContactoEmpleadoEntity extends EmpleadoEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@NotEmpty(message="El campo telefono no puede ser vacio.")
	@Size(min=3, max=15, message="Tamaño del campo telefono no es válido.")
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
