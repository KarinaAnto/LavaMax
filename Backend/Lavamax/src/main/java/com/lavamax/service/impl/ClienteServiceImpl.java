package com.lavamax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavamax.model.entities.Cliente;
import com.lavamax.model.repository.ClienteRepository;
import com.lavamax.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente registrar(Cliente t) {
		return clienteRepository.save(t);
	}

	@Override
	public Cliente modificar(Cliente t) {
		return clienteRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		clienteRepository.deleteById(id);
		
	}

	@Override
	public Optional<Cliente> listId(int id) {
		return clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

}
