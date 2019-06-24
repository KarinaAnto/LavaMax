package com.lavamax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavamax.model.entities.Catalogo;
import com.lavamax.model.repository.CatalogoRepository;
import com.lavamax.service.CatalogoService;

@Service
public class CatalogoServiceImpl implements CatalogoService{

	@Autowired
	private CatalogoRepository catalogoRepository;
	
	@Override
	public Catalogo registrar(Catalogo t) {
		return catalogoRepository.save(t);
	}

	@Override
	public Catalogo modificar(Catalogo t) {
		return catalogoRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		catalogoRepository.deleteById(id);
		
	}

	@Override
	public Optional<Catalogo> listId(int id) {
		return catalogoRepository.findById(id);
	}

	@Override
	public List<Catalogo> listar() {
		return catalogoRepository.findAll();
	}

}
