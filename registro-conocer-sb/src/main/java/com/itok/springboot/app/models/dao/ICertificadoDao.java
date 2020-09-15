package com.itok.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.itok.springboot.app.models.entity.Certificado;

public interface ICertificadoDao extends PagingAndSortingRepository<Certificado,Integer>{
	@Query("select p from Certificado p where p.estado = 1")
	public List<Certificado> findByActivo();
	
}
