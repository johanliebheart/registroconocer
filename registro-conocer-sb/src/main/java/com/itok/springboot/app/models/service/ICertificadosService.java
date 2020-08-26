package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.itok.springboot.app.models.entity.Certificados;

public interface ICertificadosService {

	public List<Certificados> findAll();
	
	public Page<Certificados> findAll(Pageable pageable);
	
	public void save(Certificados certificados);
	
	public Certificados findOne(int id);
	
	public void delete(int id);
}
