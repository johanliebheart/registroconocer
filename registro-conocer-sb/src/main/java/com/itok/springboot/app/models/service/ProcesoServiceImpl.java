package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.itok.springboot.app.models.dao.IProcesoDao;
import com.itok.springboot.app.models.entity.Proceso;
@Service
public class ProcesoServiceImpl implements IProcesoService {

	@Autowired
	private IProcesoDao procesoDao;
	
	@Autowired
	@Override
	public List<Proceso> findAll() {
		
		return (List<Proceso>) procesoDao.findAll();
	}

	@Override
	public Page<Proceso> findAll(Pageable pageable) {
		
		return procesoDao.findAll(pageable);
	}

	@Override
	public void save(Proceso proceso) {
		procesoDao.save(proceso);
		
	}

	@Override
	public Proceso findOne(int id) {
		
		return procesoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(int id) {
		procesoDao.deleteById(id);
		
	}

	@Override
	public List<Proceso> findByActivo() {
		
		return (List<Proceso>) procesoDao.findByActivo();
	}

	
}
