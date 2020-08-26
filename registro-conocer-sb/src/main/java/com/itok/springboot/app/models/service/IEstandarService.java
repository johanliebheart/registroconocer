package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.itok.springboot.app.models.entity.Estandar;

public interface IEstandarService {

	public List<Estandar> findAll();
	
	public Page<Estandar> findAll(Pageable pageable);
	
	public void save (Estandar estandar);
	
	public Estandar findOne(int id);
	
	public void delete(int id);
	
	
	
}
