package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.itok.springboot.app.models.entity.FichaRegistro;

public interface IFichaRegistroService {
	
	public List<FichaRegistro> findAll();

	public Page<FichaRegistro> findAll(Pageable pageable);
	
	public void save(FichaRegistro fichaRegistro);
	
	public FichaRegistro findOne(int id);
	
	public void delete(int id);
	
	public List<FichaRegistro> findByActivo();
	
	public boolean activaProceso(FichaRegistro fichaRegistro) ;
	
	
}
