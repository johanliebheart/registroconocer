package com.itok.springboot.app.models.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.itok.springboot.app.models.entity.EstandaresAutorizados;

public interface IEstandaresAutorizadosService {

public List<EstandaresAutorizados> findAll();

public Page<EstandaresAutorizados> findAll(Pageable pageable);

public void save(EstandaresAutorizados estandarAutorizado);

public EstandaresAutorizados findOne(int id);

public void delete(int id);

//public List<EstandaresAutorizados> findByEvaluador(int id);
}
