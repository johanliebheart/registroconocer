package com.itok.springboot.app.models.service;

import java.util.List;

import com.itok.springboot.app.models.entity.LoteDictamen;

public interface ILoteDictamenService {
	
	public List<LoteDictamen> findAll();
	
	public void save(LoteDictamen loteDictamen);
	
	public LoteDictamen findOne(int id);
	
	public void delete(int id);

}
