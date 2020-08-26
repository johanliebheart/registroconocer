package com.itok.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.itok.springboot.app.models.entity.FichaRegistro;

public interface IFichaRegistroDao extends PagingAndSortingRepository<FichaRegistro, Integer>{

	
	@Query("select p from FichaRegistro p where p.proceso = 0")
	public List<FichaRegistro> findByActivo();
}
