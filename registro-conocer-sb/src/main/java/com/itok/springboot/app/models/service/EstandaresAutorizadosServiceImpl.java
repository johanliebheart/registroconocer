package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.itok.springboot.app.models.dao.IEstandaresAutorizadosDao;
import com.itok.springboot.app.models.entity.EstandaresAutorizados;

@Service
public class EstandaresAutorizadosServiceImpl implements IEstandaresAutorizadosService {

	@Autowired
	private IEstandaresAutorizadosDao estandaresAutorizadosDao;
	
	@Override
	public List<EstandaresAutorizados> findAll() {
		
		return (List<EstandaresAutorizados>) estandaresAutorizadosDao.findAll();
	}

	@Override
	public Page<EstandaresAutorizados> findAll(Pageable pageable) {
	
		return estandaresAutorizadosDao.findAll(pageable);
	}

	@Override
	public void save(EstandaresAutorizados estandarAutorizado) {
		estandaresAutorizadosDao.save(estandarAutorizado);
		
	}

	@Override
	public EstandaresAutorizados findOne(int id) {
		
		return estandaresAutorizadosDao.findById(id).orElse(null);
	}

	@Override
	public void delete(int id) {
		estandaresAutorizadosDao.deleteById(id);
		
	}

	
	
}
