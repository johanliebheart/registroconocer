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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Certificados implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCertificado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proceso", nullable = false)
	private Proceso idProceso;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date vigencia;
	
	private boolean impresionCert;
	
	private boolean impresionCred;
	
	private String folioCertificado;

	private boolean estado;

	private boolean emision;
	
	
	public Certificados() {
		
	}


	public int getIdCertificado() {
		return idCertificado;
	}


	public void setIdCertificado(int idCertificado) {
		this.idCertificado = idCertificado;
	}


	public Proceso getIdProceso() {
		return idProceso;
	}


	public void setIdProceso(Proceso idProceso) {
		this.idProceso = idProceso;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	

	public Date getVigencia() {
		return vigencia;
	}


	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}


	public boolean isImpresionCert() {
		return impresionCert;
	}


	public void setImpresionCert(boolean impresionCert) {
		this.impresionCert = impresionCert;
	}


	public boolean isImpresionCred() {
		return impresionCred;
	}


	public void setImpresionCred(boolean impresionCred) {
		this.impresionCred = impresionCred;
	}


	public String getFolioCertificado() {
		return folioCertificado;
	}


	public void setFolioCertificado(String folioCertificado) {
		this.folioCertificado = folioCertificado;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public boolean isEmision() {
		return emision;
	}


	public void setEmision(boolean emision) {
		this.emision = emision;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Certificados [idCertificado=" + idCertificado + ", idProceso=" + idProceso + ", fecha=" + fecha
				+ ", vigencia=" + vigencia + ", impresionCert=" + impresionCert + ", impresionCred=" + impresionCred
				+ ", folioCertificado=" + folioCertificado + ", estado=" + estado + ", emision=" + emision + "]";
	}

	
	

}
