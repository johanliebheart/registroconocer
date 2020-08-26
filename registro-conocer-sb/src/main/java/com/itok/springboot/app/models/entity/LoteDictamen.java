package com.itok.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class LoteDictamen implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idLoteDictamen;
	
	private int numeroFichas;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaDictamen;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaCaptura;
	
	
	private boolean procedente = true;

	@OneToMany(mappedBy = "loteDictamen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Proceso> proceso;

	@PrePersist()
	public void setFechaCaptura() {
		fechaCaptura = new Date();
	}
	

	public int getIdLoteDictamen() {
		return idLoteDictamen;
	}

	public void setIdLoteDictamen(int idLoteDictamen) {
		this.idLoteDictamen = idLoteDictamen;
	}


	public int getNumeroFichas() {
		return numeroFichas;
	}

	public void setNumeroFichas(int numeroFichas) {
		this.numeroFichas = numeroFichas;
	}

	public Date getFechaDictamen() {
		return fechaDictamen;
	}

	public Date getFechaCaptura() {
		return fechaCaptura;
	}

	public void setFechaDictamen(Date fechaDictamen) {
		this.fechaDictamen = fechaDictamen;
	}

	public boolean isProcedente() {
		return procedente;
	}

	public void setProcedente(boolean procedente) {
		this.procedente = procedente;
	}


}
