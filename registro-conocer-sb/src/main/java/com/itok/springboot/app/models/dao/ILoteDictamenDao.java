package com.itok.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.itok.springboot.app.models.entity.LoteDictamen;

public interface ILoteDictamenDao extends PagingAndSortingRepository<LoteDictamen, Integer> {
	
	@Query("select p from LoteDictamen p where p.estado = 1")
	public List<LoteDictamen> findByActivo();

	
}
