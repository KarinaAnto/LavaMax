package com.lavamax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavamax.model.entities.Estado;
import com.lavamax.model.repository.EstadoRepository;
import com.lavamax.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService{

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public Estado registrar(Estado t) {
		return estadoRepository.save(t);
	}

	@Override
	public Estado modificar(Estado t) {
		return estadoRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		estadoRepository.deleteById(id);
		
	}

	@Override
	public Optional<Estado> listId(int id) {
		return estadoRepository.findById(id);
	}

	@Override
	public List<Estado> listar() {
		return estadoRepository.findAll();
	}

}
