package com.itok.springboot.app.models.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.itok.springboot.app.models.entity.EstandaresAutorizados;

public interface IEstandaresAutorizadosDao extends PagingAndSortingRepository<EstandaresAutorizados, Integer> {

	@Query("select p from EstandaresAutorizados p where p.idEvaluadorIndependiente.idEvaluadorIndependiente = ?1")
	public List<EstandaresAutorizados> findByEvaluador(int id);
	
}
