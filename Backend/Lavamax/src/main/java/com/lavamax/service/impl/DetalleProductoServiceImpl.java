package com.lavamax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavamax.model.entities.DetalleProducto;
import com.lavamax.model.repository.DetalleProductoRepository;
import com.lavamax.service.DetalleProductoService;

@Service
public class DetalleProductoServiceImpl implements DetalleProductoService{

	@Autowired
	private DetalleProductoRepository detalleProductoRepository;
	
	@Override
	public DetalleProducto registrar(DetalleProducto t) {
		return detalleProductoRepository.save(t);
	}

	@Override
	public DetalleProducto modificar(DetalleProducto t) {
		return detalleProductoRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		detalleProductoRepository.deleteById(id);
		
	}

	@Override
	public Optional<DetalleProducto> listId(int id) {
		return detalleProductoRepository.findById(id);
	}

	@Override
	public List<DetalleProducto> listar() {
		return detalleProductoRepository.findAll();
	}

}
