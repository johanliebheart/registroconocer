package com.itok.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.itok.springboot.app.models.dao.IFichaRegistroDao;
import com.itok.springboot.app.models.entity.FichaRegistro;
@Service
public class FichaRegistroServiceImpl implements IFichaRegistroService {

	@Autowired
	private IFichaRegistroDao fichaRegistroDao;
	
	
	
	@Override
	public List<FichaRegistro> findAll() {
		
		return (List<FichaRegistro>) fichaRegistroDao.findAll();
	}

	@Override
	public Page<FichaRegistro> findAll(Pageable pageable) {
		
		return fichaRegistroDao.findAll(pageable);
	}

	@Override
	public void save(FichaRegistro fichaRegistro) {
		fichaRegistroDao.save(fichaRegistro);
	}

	@Override
	public FichaRegistro findOne(int id) {
		
		return fichaRegistroDao.findById(id).orElse(null);
	}

	@Override
	public void delete(int id) {
		fichaRegistroDao.deleteById(id);
		
	}

	@Override
	public List<FichaRegistro> findByActivo() {
		return (List<FichaRegistro>) fichaRegistroDao.findByActivo();
	}

	@Override
	public boolean activaProceso(FichaRegistro fichaRegistro) {
		boolean a= false;
		fichaRegistro.setProceso(1);
		fichaRegistroDao.save(fichaRegistro);
		return a;
	}
	
	
}
