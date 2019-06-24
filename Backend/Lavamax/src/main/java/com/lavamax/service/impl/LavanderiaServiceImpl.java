package com.lavamax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavamax.model.entities.Lavanderia;
import com.lavamax.model.repository.LavanderiaRepository;
import com.lavamax.service.LavanderiaService;

@Service
public class LavanderiaServiceImpl implements LavanderiaService {

	@Autowired
	private LavanderiaRepository lavanderiaRepository;
	
	@Override
	public Lavanderia registrar(Lavanderia t) {
		return lavanderiaRepository.save(t);
	}

	@Override
	public Lavanderia modificar(Lavanderia t) {
		return lavanderiaRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		lavanderiaRepository.deleteById(id);
		
	}

	@Override
	public Optional<Lavanderia> listId(int id) {
		return lavanderiaRepository.findById(id);
	}

	@Override
	public List<Lavanderia> listar() {
		return lavanderiaRepository.findAll();
	}

}
