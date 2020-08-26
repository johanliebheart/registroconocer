package com.itok.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.itok.springboot.app.models.entity.LoteDictamen;

public interface ILoteDictamenDao extends PagingAndSortingRepository<LoteDictamen, Integer>{

}
