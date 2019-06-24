package com.lavamax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavamax.model.entities.TipoPago;
import com.lavamax.model.repository.TipoPagoRepository;
import com.lavamax.service.TipoPagoService;

@Service
public class TipoPagoServiceImpl implements TipoPagoService{

	@Autowired
	private TipoPagoRepository tipopagoRepository;
	
	@Override
	public TipoPago registrar(TipoPago t) {
		return tipopagoRepository.save(t);
	}

	@Override
	public TipoPago modificar(TipoPago t) {
		return tipopagoRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		 tipopagoRepository.deleteById(id);
		
	}

	@Override
	public Optional<TipoPago> listId(int id) {
		return tipopagoRepository.findById(id);
	}

	@Override
	public List<TipoPago> listar() {
		return tipopagoRepository.findAll();
	}

}
