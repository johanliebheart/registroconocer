package com.itok.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.itok.springboot.app.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer>{

	public Usuario findByUsername(String username);
	
	
}
