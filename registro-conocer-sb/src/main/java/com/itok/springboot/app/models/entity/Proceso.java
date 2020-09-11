package com.itok.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Proceso implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProceso;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ficha_registro")
	private FichaRegistro idFichaRegistro;
	
	private String juicio;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaJuicio;
	
	
	private int estado;
	
	private boolean certificado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_lote_dictamen")
	private LoteDictamen idLoteDictamen;
	
	@Transient
	public int temporal;


	public int getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	public FichaRegistro getIdFichaRegistro() {
		return idFichaRegistro;
	}

	public void setIdFichaRegistro(FichaRegistro idFichaRegistro) {
		this.idFichaRegistro = idFichaRegistro;
	}


	public String getJuicio() {
		return juicio;
	}

	public void setJuicio(String juicio) {
		this.juicio = juicio;
	}



	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public boolean isCertificado() {
		return certificado;
	}

	public void setCertificado(boolean certificado) {
		this.certificado = certificado;
	}


	public Date getFechaJuicio() {
		return fechaJuicio;
	}

	public LoteDictamen getIdLoteDictamen() {
		return idLoteDictamen;
	}

	public void setIdLoteDictamen(LoteDictamen idLoteDictamen) {
		this.idLoteDictamen = idLoteDictamen;
	}

	public void setFechaJuicio(Date fechaJuicio) {
		this.fechaJuicio = fechaJuicio;
	}

	
	public int getTemporal() {
		return temporal;
	}

	public void setTemporal(int temporal) {
		this.temporal = temporal;
	}

	@Override
	public String toString() {
		return "Proceso [idProceso=" + idProceso + ", idFichaRegistro=" + idFichaRegistro + ", juicio=" + juicio
				+ ", fechaEnvioDictamen=" + fechaJuicio + ", estado=" + estado
				+ ", certificado=" + certificado + ", idLoteDictamen=" + idLoteDictamen + "]";
	}


}
