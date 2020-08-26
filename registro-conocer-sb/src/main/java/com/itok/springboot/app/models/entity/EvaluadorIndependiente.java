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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="evaluador_independiente")
public class EvaluadorIndependiente implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idEvaluadorIndependiente;
		
		/*
		@OneToOne()
		@JoinColumn(name = "id_usuario")
		private Usuario idUsuario;
		*/
		private String nombre;
		
		private boolean estado = true;
		
		@NotNull
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date fechaAlta;
		
		private int noEvaluadores;

		@OneToMany(mappedBy = "idEvaluadorIndependiente" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private List<EstandaresAutorizados> estandaresAutorizados;
		
		@OneToMany(mappedBy = "idEvaluadorIndependiente" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private List<FichaRegistro> fichaRegistro;
		
		@PrePersist
		public void prePersist() { 
			fechaAlta = new Date();
		}
		
		public EvaluadorIndependiente() {
			estandaresAutorizados=new ArrayList<EstandaresAutorizados>();
			fichaRegistro = new ArrayList<FichaRegistro>();
		}

		public int getIdEvaluadorIndependiente() {
			return idEvaluadorIndependiente;
		}

		public void setIdEvaluadorIndependiente(int idEvaluadorIndependiente) {
			this.idEvaluadorIndependiente = idEvaluadorIndependiente;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}

		public Date getFechaAlta() {
			return fechaAlta;
		}

		public void setFechaAlta(Date fechaAlta) {
			this.fechaAlta = fechaAlta;
		}

		public int getNoEvaluadores() {
			return noEvaluadores;
		}

		public void setNoEvaluadores(int noEvaluadores) {
			this.noEvaluadores = noEvaluadores;
		}

		public List<EstandaresAutorizados> getEstandaresAutorizados() {
			return estandaresAutorizados;
		}

		public void setEstandaresAutorizados(List<EstandaresAutorizados> estandaresAutorizados) {
			this.estandaresAutorizados = estandaresAutorizados;
		}

		public List<FichaRegistro> getFichaRegistro() {
			return fichaRegistro;
		}

		public void setFichaRegistro(List<FichaRegistro> fichaRegistro) {
			this.fichaRegistro = fichaRegistro;
		}

		


		
		
		
}
