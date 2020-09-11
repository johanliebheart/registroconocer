package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itok.springboot.app.models.dao.IProcesoDao;
import com.itok.springboot.app.models.entity.Proceso;
@Service
public class ProcesoServiceImpl implements IProcesoService {

	@Autowired
	private IProcesoDao procesoDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Proceso> findAll() {
		
		return (List<Proceso>) procesoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Proceso> findAll(Pageable pageable) {
		
		return procesoDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Proceso proceso) {
		procesoDao.save(proceso);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Proceso findOne(int id) {
		
		return procesoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(int id) {
		procesoDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Proceso> findByActivo() {
		
		return (List<Proceso>) procesoDao.findByActivo();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Proceso> findByCompetente() {
		return (List<Proceso>) procesoDao.findByCompetente();
	}

	
}
