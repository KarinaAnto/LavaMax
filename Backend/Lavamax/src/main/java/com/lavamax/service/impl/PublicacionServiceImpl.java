package com.lavamax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavamax.model.entities.Publicacion;
import com.lavamax.model.repository.PublicacionRepository;
import com.lavamax.service.PublicacionService;

@Service
public class PublicacionServiceImpl implements PublicacionService {

	@Autowired
	private PublicacionRepository publicacionRepository;
	
	@Override
	public Publicacion registrar(Publicacion t) {
		return publicacionRepository.save(t);
	}

	@Override
	public Publicacion modificar(Publicacion t) {
		return publicacionRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		publicacionRepository.deleteById(id);
		
	}

	@Override
	public Optional<Publicacion> listId(int id) {
		return publicacionRepository.findById(id);
	}

	@Override
	public List<Publicacion> listar() {
		return publicacionRepository.findAll();
	}

	
	
}
