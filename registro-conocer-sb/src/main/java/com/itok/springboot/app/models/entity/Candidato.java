package com.itok.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Candidato implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCandidato;
	
	@NotEmpty
	private String nombre;
	 
	@NotEmpty
	private String apellidoP;
	
	@NotEmpty
	private String apellidoM;
	
	@NotEmpty
	private String lugarNacimiento;
	 	
	@NotEmpty
	private String nacionalidad;
	
	@NotEmpty
	@Email 
	private String email;
	
	@NotEmpty
	@Size(min=18,max=18)
	private String curp;
	
	@NotEmpty
	private String genero ="Femenino";
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@NotEmpty
	private String domicilio;
		
	@NotEmpty
	private String telefono;
		
	@NotEmpty
	private String telefonoCel;
	
	private String imageReference;
	
	
	private String estado="Primera Vez";


	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<FichaRegistro> fichaRegistro;
	
	
	public Candidato() {
		fichaRegistro = new ArrayList<FichaRegistro>();
	}


	public int getIdCandidato() {
		return idCandidato;
	}


	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidoP() {
		return apellidoP;
	}


	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}


	public String getApellidoM() {
		return apellidoM;
	}


	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}


	public String getLugarNacimiento() {
		return lugarNacimiento;
	}


	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCurp() {
		return curp;
	}


	public void setCurp(String curp) {
		this.curp = curp;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getTelefonoCel() {
		return telefonoCel;
	}


	public void setTelefonoCel(String telefonoCel) {
		this.telefonoCel = telefonoCel;
	}


	public String getImageReference() {
		return imageReference;
	}


	public void setImageReference(String imageReference) {
		this.imageReference = imageReference;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public List<FichaRegistro> getFichaRegistro() {
		return fichaRegistro;
	}


	public void setFichaRegistro(List<FichaRegistro> fichaRegistro) {
		this.fichaRegistro = fichaRegistro;
	}


	@Override
	public String toString() {
		return "Candidato [idCandidato=" + idCandidato + ", nombre=" + nombre + ", apellidoP=" + apellidoP
				+ ", apellidoM=" + apellidoM + ", lugarNacimiento=" + lugarNacimiento + ", nacionalidad=" + nacionalidad
				+ ", email=" + email + ", curp=" + curp + ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento
				+ ", domicilio=" + domicilio + ", telefono=" + telefono + ", telefonoCel=" + telefonoCel
				+ ", imageReference=" + imageReference + ", estado=" + estado + ", fichaRegistro=" + fichaRegistro
				+ "]";
	}


	


}
