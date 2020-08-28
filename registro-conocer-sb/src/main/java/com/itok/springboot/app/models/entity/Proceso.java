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
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "proceso")
public class Proceso implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProceso;
	
	@OneToOne()
	@JoinColumn(name = "id_ficha_registro")
	private FichaRegistro idFichaRegistro;
	
	private String dictamen;

	private String juicio;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaEnvioDictamen;
	
	private int estado;
	
	private boolean certificado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_lote_dictamen")
	private LoteDictamen idLoteDictamen;
	
	
	public Proceso() {

	}

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

	public String getDictamen() {
		return dictamen;
	}

	public void setDictamen(String dictamen) {
		this.dictamen = dictamen;
	}

	public String getJuicio() {
		return juicio;
	}

	public void setJuicio(String juicio) {
		this.juicio = juicio;
	}

	public Date getFechaEnvioDictamen() {
		return fechaEnvioDictamen;
	}

	public void setFechaEnvioDictamen(Date fechaEnvioDictamen) {
		this.fechaEnvioDictamen = fechaEnvioDictamen;
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

	public LoteDictamen getIdLoteDictamen() {
		return idLoteDictamen;
	}

	public void setIdLoteDictamen(LoteDictamen idLoteDictamen) {
		this.idLoteDictamen = idLoteDictamen;
	}


	

	
}
