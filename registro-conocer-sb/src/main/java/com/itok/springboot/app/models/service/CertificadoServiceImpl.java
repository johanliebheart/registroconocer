package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itok.springboot.app.models.dao.ICertificadoDao;
import com.itok.springboot.app.models.entity.Certificado;
@Service
public class CertificadoServiceImpl implements ICertificadoService {

	@Autowired
	private ICertificadoDao certificadoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Certificado> findAll() {
		
		return (List<Certificado>) certificadoDao.findAll();
	}

	
	@Override
	public List<Certificado> findByActivo() {
		return (List<Certificado>) certificadoDao.findByActivo();
	}


	@Override
	@Transactional(readOnly = true)
	public Page<Certificado> findAll(Pageable pageable) {
		return certificadoDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Certificado certificados) {
		certificadoDao.save(certificados);
	}

	@Override
	@Transactional(readOnly = true)
	public Certificado findOne(int id) {
		return certificadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(int id) {
		certificadoDao.deleteById(id);
	}

}
