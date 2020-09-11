package com.itok.springboot.app.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itok.springboot.app.models.dao.IEstandaresAutorizadosDao;
import com.itok.springboot.app.models.dao.IEvaluadorIndependienteDao;
import com.itok.springboot.app.models.entity.EstandaresAutorizados;
import com.itok.springboot.app.models.entity.EvaluadorIndependiente;

@Service
public class EvaluadorIndependienteServiceImpl implements IEvaluadorIndependienteService {

	@Autowired
	 private IEvaluadorIndependienteDao evaluadorIndependienteDao;
	
	@Autowired
	private IEstandaresAutorizadosDao estandaresAutorizadosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<EvaluadorIndependiente> findAll() {
		
		return (List<EvaluadorIndependiente>) evaluadorIndependienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<EvaluadorIndependiente> findAll(Pageable pageable) {
		
		return evaluadorIndependienteDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(EvaluadorIndependiente evaluadorIndependiente) {
		evaluadorIndependienteDao.save(evaluadorIndependiente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public EvaluadorIndependiente findOne(int id) {
		
		return evaluadorIndependienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(int id) {
		evaluadorIndependienteDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<EvaluadorIndependiente> findByNombre(String term) {
		
		return evaluadorIndependienteDao.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EstandaresAutorizados> findEstandares(int id) {
		
		return estandaresAutorizadosDao.findByEvaluador(id);
	}
	
	
}
