package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.itok.springboot.app.models.dao.IEstandarDao;
import com.itok.springboot.app.models.entity.Estandar;
@Service
public class EstandarServiceImpl implements IEstandarService {

	@Autowired
	private IEstandarDao estandarDao;
	
	@Override
	public List<Estandar> findAll() {
		
		return (List<Estandar>) estandarDao.findAll();
	}

	@Override
	public Page<Estandar> findAll(Pageable pageable) {
		
		return estandarDao.findAll(pageable);
	}

	@Override
	public void save(Estandar estandar) {
		estandarDao.save(estandar);
		
	}

	@Override
	public Estandar findOne(int id) {
	
		return estandarDao.findById(id).orElse(null);
	}

	@Override
	public void delete(int id) {
		estandarDao.deleteById(id);
	}

}
