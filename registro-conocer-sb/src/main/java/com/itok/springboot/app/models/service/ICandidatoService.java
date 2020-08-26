package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.itok.springboot.app.models.entity.Candidato;

public interface ICandidatoService {
	
	public List<Candidato> findAll();
	
	public Page<Candidato> findAll(Pageable pageable);
	
	public void save(Candidato candidato);
	
	public int saveGetId(Candidato candidato);
	
	public Candidato findOne(int id);
	
	public void delete(int id);

}
