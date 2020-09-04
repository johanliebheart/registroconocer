package com.itok.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.itok.springboot.app.models.entity.Proceso;

public interface IProcesoDao extends PagingAndSortingRepository<Proceso, Integer>{

	@Query("select p from Proceso p where p.estado = 1")
	public List<Proceso> findByActivo();
	
	//@Query("select p from Proceso p where p.dictamen = 'Competente' AND p.certificado=0")
	//public List<Proceso> findByCompetente();
}
