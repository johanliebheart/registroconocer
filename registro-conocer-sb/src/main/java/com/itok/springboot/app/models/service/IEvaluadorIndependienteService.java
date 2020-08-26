package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.itok.springboot.app.models.entity.EstandaresAutorizados;
import com.itok.springboot.app.models.entity.EvaluadorIndependiente;

public interface IEvaluadorIndependienteService {
	
	public List<EvaluadorIndependiente> findAll();
	
	public Page<EvaluadorIndependiente> findAll(Pageable pageable);
	
	public void save(EvaluadorIndependiente evaluadorIndependiente);
	
	public EvaluadorIndependiente findOne(int id);
	
	public void delete(int id);
	
	public List<EvaluadorIndependiente> findByNombre(String term);
	
	public List<EstandaresAutorizados> findEstandares(int id);

}
