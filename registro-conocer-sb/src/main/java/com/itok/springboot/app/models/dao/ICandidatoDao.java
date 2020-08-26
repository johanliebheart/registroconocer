package com.itok.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.itok.springboot.app.models.entity.Candidato;

public interface ICandidatoDao extends PagingAndSortingRepository<Candidato,Integer>{

}
