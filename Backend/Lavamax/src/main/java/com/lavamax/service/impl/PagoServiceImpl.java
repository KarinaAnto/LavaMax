package com.lavamax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavamax.model.entities.Pago;
import com.lavamax.model.repository.PagoRepository;
import com.lavamax.service.PagoService;

@Service
public class PagoServiceImpl implements PagoService {

	@Autowired
	private PagoRepository pagoRepository;
	
	@Override
	public Pago registrar(Pago t) {
		return pagoRepository.save(t);
	}

	@Override
	public Pago modificar(Pago t) {
		return pagoRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		pagoRepository.deleteById(id);
		
	}

	@Override
	public Optional<Pago> listId(int id) {
		return pagoRepository.findById(id);
	}

	@Override
	public List<Pago> listar() {
		return pagoRepository.findAll();
	}

}
