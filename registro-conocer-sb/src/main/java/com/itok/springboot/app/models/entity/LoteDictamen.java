package com.itok.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import com.sun.istack.NotNull;

@Entity
public class LoteDictamen implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idLoteDictamen;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaDictamen;
	
	@Column(name = "fecha_capturada")
	@Temporal(TemporalType.DATE)
	private Date fechaCapturada;
	
	private int numeroFichas;
	
	private int procedente;
	
	private int estado;

	@PrePersist
	public void setFechaCaptura() {
		fechaCapturada = new Date();
	}

	public Date getFechaCapturada() {
		return fechaCapturada;
	}

	public void setFechaCapturada(Date fechaCapturada) {
		this.fechaCapturada = fechaCapturada;
	}
	public int getIdLoteDictamen() {
		return idLoteDictamen;
	}

	public void setIdLoteDictamen(int idLoteDictamen) {
		this.idLoteDictamen = idLoteDictamen;
	}

	public Date getFechaDictamen() {
		return fechaDictamen;
	}

	public void setFechaDictamen(Date fechaDictamen) {
		this.fechaDictamen = fechaDictamen;
	}

	public int getNumeroFichas() {
		return numeroFichas;
	}

	public void setNumeroFichas(int numeroFichas) {
		this.numeroFichas = numeroFichas;
	}

	public int getProcedente() {
		return procedente;
	}

	public void setProcedente(int procedente) {
		this.procedente = procedente;
	}

	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "LoteDictamen [idLoteDictamen=" + idLoteDictamen + ", fechaDictamen=" + fechaDictamen
				+ ", fechaCapturada=" + fechaCapturada + ", numeroFichas=" + numeroFichas + ", procedente=" + procedente
				+ "]";
	}


	
}