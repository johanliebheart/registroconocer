package com.itok.springboot.app.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itok.springboot.app.models.dao.IUsuarioDao;
import com.itok.springboot.app.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(int id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(int id) {
		usuarioDao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable){
		return usuarioDao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean validateUser(Usuario usuario) {
		Usuario comparator = findOne(usuario.getIdUsuario());
			if(comparator != null) {
				if(comparator.getPassword().equals(usuario.getPassword())) {
					return true;
				}else {
					return false;
				}
			}else 
				return false;
	}

	@Override
	@Transactional(readOnly = true)
	public int typeUser(Usuario usuario) {
		Usuario comparator = findOne(usuario.getIdUsuario());
		return comparator.getTipoDeUsuario();
	}
}
