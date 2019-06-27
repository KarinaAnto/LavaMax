package com.lavamax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavamax.model.entities.Lavanderia;
import com.lavamax.model.entities.Local;
import com.lavamax.model.repository.LocalRepository;
import com.lavamax.service.LocalService;

@Service
public class LocalServiceImpl implements LocalService {

	@Autowired
	private LocalRepository localRepository;
	
	@Override
	public Local registrar(Local t) {
		return localRepository.save(t);
	}

	@Override
	public Local modificar(Local t) {
		return localRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		localRepository.deleteById(id);
		
	}

	@Override
	public Optional<Local> listId(int id) {
		return localRepository.findById(id);
	}

	@Override
	public List<Local> listar() {
		return localRepository.findAll();
	}

	@Override
	public List<Local> listLocalByLavanderiaId(int lavanderiaId) {
		return localRepository.findLocalByLavanderiaId(lavanderiaId);
	}

}
