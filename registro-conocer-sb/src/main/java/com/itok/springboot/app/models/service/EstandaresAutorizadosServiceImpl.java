package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itok.springboot.app.models.dao.IEstandaresAutorizadosDao;
import com.itok.springboot.app.models.entity.EstandaresAutorizados;

@Service
public class EstandaresAutorizadosServiceImpl implements IEstandaresAutorizadosService {

	@Autowired
	private IEstandaresAutorizadosDao estandaresAutorizadosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<EstandaresAutorizados> findAll() {
		
		return (List<EstandaresAutorizados>) estandaresAutorizadosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<EstandaresAutorizados> findAll(Pageable pageable) {
	
		return estandaresAutorizadosDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(EstandaresAutorizados estandarAutorizado) {
		estandaresAutorizadosDao.save(estandarAutorizado);
		
	}

	@Override
	@Transactional(readOnly = true)
	public EstandaresAutorizados findOne(int id) {
		
		return estandaresAutorizadosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(int id) {
		estandaresAutorizadosDao.deleteById(id);
		
	}

	
	
}
