package com.lavamax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavamax.model.entities.Producto;
import com.lavamax.model.repository.ProductoRepository;
import com.lavamax.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public Producto registrar(Producto t) {
		return productoRepository.save(t);
	}

	@Override
	public Producto modificar(Producto t) {
		return productoRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		productoRepository.deleteById(id);
		
	}

	@Override
	public Optional<Producto> listId(int id) {
		return productoRepository.findById(id);
	}

	@Override
	public List<Producto> listar() {
		return productoRepository.findAll();
	}

}
