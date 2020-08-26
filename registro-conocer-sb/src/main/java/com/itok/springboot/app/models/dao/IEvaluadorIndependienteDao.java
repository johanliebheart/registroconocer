package com.itok.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.itok.springboot.app.models.entity.EvaluadorIndependiente;

public interface IEvaluadorIndependienteDao extends PagingAndSortingRepository<EvaluadorIndependiente, Integer>{
	
	@Query("select p from EvaluadorIndependiente p where p.nombre like %?1%")
	public List<EvaluadorIndependiente> findByNombre(String term);

}
