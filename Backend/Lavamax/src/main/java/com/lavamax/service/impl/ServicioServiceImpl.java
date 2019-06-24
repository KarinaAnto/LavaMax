package com.lavamax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavamax.model.entities.Servicio;
import com.lavamax.model.repository.ServicioRepository;
import com.lavamax.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService{

	@Autowired
	private ServicioRepository servicioRepository;

	@Override
	public Servicio registrar(Servicio t) {
		return servicioRepository.save(t);
	}

	@Override
	public Servicio modificar(Servicio t) {
		return servicioRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		servicioRepository.deleteById(id);
	}

	@Override
	public Optional<Servicio> listId(int id) {
		return servicioRepository.findById(id);
	}

	@Override
	public List<Servicio> listar() {
		return servicioRepository.findAll();
	}
}
