package com.itok.springboot.app.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.itok.springboot.app.models.dao.ILoteDictamenDao;
import com.itok.springboot.app.models.entity.LoteDictamen;
@Service
public class LoteDictamenServiceImpl implements ILoteDictamenService {

	@Autowired
	private ILoteDictamenDao loteDictamenDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<LoteDictamen> findAll() {
		
		return (List<LoteDictamen>) loteDictamenDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<LoteDictamen> findByProcedente() {
		return (List<LoteDictamen>) loteDictamenDao.findByProcedente();
	}

	@Override
	@Transactional
	public void save(LoteDictamen lote) {
		loteDictamenDao.save(lote);
	}

	@Override
	@Transactional(readOnly = true)
	public LoteDictamen findOne(int id) {
		return loteDictamenDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(int id) {
		loteDictamenDao.deleteById(id);

	}

	
}
