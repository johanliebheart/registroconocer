package com.itok.springboot.app.models.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario  implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	
	private String password;
	
	private String nombre;
	
	private int tipoDeUsuario;
	
	
	private int estado;


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getTipoDeUsuario() {
		return tipoDeUsuario;
	}


	public void setTipoDeUsuario(int tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", password=" + password + ", nombre=" + nombre + ", tipoDeUsuario="
				+ tipoDeUsuario + ", estado=" + estado + "]";
	}


	

	
}
