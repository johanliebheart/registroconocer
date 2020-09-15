package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.itok.springboot.app.models.entity.Certificado;

public interface ICertificadoService {

	public List<Certificado> findAll();
	
	public List<Certificado> findByActivo();
	
	public Page<Certificado> findAll(Pageable pageable);
	
	public void save(Certificado certificados);
	
	public Certificado findOne(int id);
	
	public void delete(int id);
}
