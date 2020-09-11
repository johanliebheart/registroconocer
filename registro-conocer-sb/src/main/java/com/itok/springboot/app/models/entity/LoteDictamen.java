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
	
	private int contador;
	
	

	public LoteDictamen(int idLoteDictamen, Date fechaDictamen, Date fechaCapturada, int numeroFichas, int procedente,
			int contador) {
		
		this.idLoteDictamen = idLoteDictamen;
		this.fechaDictamen = fechaDictamen;
		this.fechaCapturada = fechaCapturada;
		this.numeroFichas = numeroFichas;
		this.procedente = procedente;
		this.contador = contador;
	}

	
	
	public LoteDictamen() {
		
	}



	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

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

	



	
}
