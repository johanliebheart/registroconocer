package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.itok.springboot.app.models.dao.ICertificadoDao;
import com.itok.springboot.app.models.entity.Certificados;
@Service
public class CertificadosServiceImpl implements ICertificadosService {

	@Autowired
	private ICertificadoDao certificadoDao;
	
	@Override
	public List<Certificados> findAll() {
		
		return (List<Certificados>) certificadoDao.findAll();
	}

	@Override
	public Page<Certificados> findAll(Pageable pageable) {
		return certificadoDao.findAll(pageable);
	}

	@Override
	public void save(Certificados certificados) {
		certificadoDao.save(certificados);
	}

	@Override
	public Certificados findOne(int id) {
		return certificadoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(int id) {
		certificadoDao.deleteById(id);
	}

}
