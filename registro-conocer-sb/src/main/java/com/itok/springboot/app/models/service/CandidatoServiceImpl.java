package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itok.springboot.app.models.dao.ICandidatoDao;
import com.itok.springboot.app.models.entity.Candidato;
@Service
public class CandidatoServiceImpl implements ICandidatoService {

	@Autowired
	private ICandidatoDao candidatoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Candidato> findAll() {
		return (List<Candidato>) candidatoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Candidato> findAll(Pageable pageable) {
		return candidatoDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Candidato candidato) {
		candidatoDao.save(candidato);
	}

	@Override
	@Transactional(readOnly = true)
	public Candidato findOne(int id) {
		return candidatoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(int id) {
		candidatoDao.deleteById(id);
	}

	@Override
	public int saveGetId(Candidato candidato) {
		Candidato cand= new Candidato();
		cand= candidatoDao.save(candidato);
		return cand.getIdCandidato();
	}

}
