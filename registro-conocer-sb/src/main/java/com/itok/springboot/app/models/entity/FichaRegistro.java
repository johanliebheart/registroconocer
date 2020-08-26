package com.itok.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class FichaRegistro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFichaRegistro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_evaluador_independiente")
	private EvaluadorIndependiente idEvaluadorIndependiente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_clave_estandar")
	private Estandar idClaveEstandar;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_candidato")
	private Candidato candidato;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaRegistro;
	
	@Column(name = "fecha_capturada")
	@Temporal(TemporalType.DATE)
	private Date fechaCapturada;

	private String estado;

	private int proceso=0;
	
	@NotNull
	private boolean aceptacion;
	
	@PrePersist
	public void setFechaCaptura() {
		fechaCapturada = new Date();
	}

	public int getIdFichaRegistro() {
		return idFichaRegistro;
	}

	public void setIdFichaRegistro(int idFichaRegistro) {
		this.idFichaRegistro = idFichaRegistro;
	}

	public EvaluadorIndependiente getIdEvaluadorIndependiente() {
		return idEvaluadorIndependiente;
	}

	public void setIdEvaluadorIndependiente(EvaluadorIndependiente idEvaluadorIndependiente) {
		this.idEvaluadorIndependiente = idEvaluadorIndependiente;
	}

	public Estandar getIdClaveEstandar() {
		return idClaveEstandar;
	}

	public void setIdClaveEstandar(Estandar idClaveEstandar) {
		this.idClaveEstandar = idClaveEstandar;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaCapturada() {
		return fechaCapturada;
	}

	public void setFechaCapturada(Date fechaCapturada) {
		this.fechaCapturada = fechaCapturada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getProceso() {
		return proceso;
	}

	public void setProceso(int proceso) {
		this.proceso = proceso;
	}

	public boolean getAceptacion() {
		return aceptacion;
	}

	public void setAceptacion(boolean aceptacion) {
		this.aceptacion = aceptacion;
	}

	@Override
	public String toString() {
		return "FichaRegistro [idFichaRegistro=" + idFichaRegistro + ", idEvaluadorIndependiente="
				+ idEvaluadorIndependiente + ", idClaveEstandar=" + idClaveEstandar + ", candidato=" + candidato
				+ ", fechaRegistro=" + fechaRegistro + ", fechaCapturada=" + fechaCapturada + ", estado=" + estado
				+ ", proceso=" + proceso + ", aceptacion=" + aceptacion + "]";
	}

}
