package com.itok.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Win_10
 *
 */
@Entity
public class EstandaresAutorizados implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstandaresAutorizados;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_evaluador_independiente")
	private EvaluadorIndependiente idEvaluadorIndependiente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_clave_estandar")
	private Estandar idClaveEstandar;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaAcreditacion;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaFinalizacion;
	
	@Transient
	private int dias;
	@Transient
	private float porcentaje;

	@PrePersist
	public void setVigencia() {
		Calendar calendar =Calendar.getInstance();
		calendar.setTime(fechaAcreditacion);
		calendar.add(Calendar.DAY_OF_YEAR, idClaveEstandar.getVigencia());
		fechaFinalizacion=calendar.getTime();
	}
	
	public int getVigencia() {
		Calendar inicio =Calendar.getInstance();
		Date hoy= new Date();
		inicio.setTime(hoy);
		System.out.println("fecha inicio: " + fechaAcreditacion);
		Calendar termino =Calendar.getInstance();
		termino.setTime(fechaFinalizacion);
		System.out.println("fecha final: " + fechaFinalizacion);
		
		int dias=-1;
		while(inicio.before(termino) ||inicio.equals(termino)) {
			dias ++;
			inicio.add(Calendar.DATE, 1);
		}
		
		return dias;
		
	}

	public int getIdEstandaresAutorizados() {
		return idEstandaresAutorizados;
	}

	public void setIdEstandaresAutorizados(int idEstandaresAutorizados) {
		this.idEstandaresAutorizados = idEstandaresAutorizados;
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

	public Date getFechaAcreditacion() {
		return fechaAcreditacion;
	}

	public void setFechaAcreditacion(Date fechaAcreditacion) {
		this.fechaAcreditacion = fechaAcreditacion;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public int getDias() {
		dias=getVigencia();
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public float getPorcentaje() {
		porcentaje= (365-getDias())*100/365;
		System.out.println("porcentaje: "+ porcentaje);
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	

	
}
