package com.itok.springboot.app.models.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.itok.springboot.app.models.entity.Usuario;


public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public void save(Usuario usuario);
	
	public Usuario findOne(int id);
	
	public void delete(int id);

	public boolean validateUser(Usuario usuario);
	
	public int typeUser(Usuario usuario);
}
