package com.itok.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.itok.springboot.app.models.entity.Usuario;

public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Integer>{

}
