package com.itok.springboot.app.models.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.itok.springboot.app.models.entity.Proceso;

public interface IProcesoService {

	public List<Proceso> findAll();
	
	public Page<Proceso> findAll(Pageable pageable);
	
	public void save(Proceso proceso);
	
	public Proceso findOne(int id);
	
	public void delete(int id);

	public List<Proceso> findByActivo();
}
