package com.itok.springboot.app.models.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "estandar")
public class Estandar implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int idClaveEstandar;
	
	private String nombre;
	
	private String clave;
	
	private int vigencia;

	public int getIdClaveEstandar() {
		return idClaveEstandar;
	}

	public void setIdClaveEstandar(int idClaveEstandar) {
		this.idClaveEstandar = idClaveEstandar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	
	public int getVigencia() {
		return vigencia;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

	

	


	
	

}
