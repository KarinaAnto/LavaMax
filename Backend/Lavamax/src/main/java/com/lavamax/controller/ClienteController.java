package com.lavamax.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lavamax.exception.ModeloNotFoundException;
import com.lavamax.model.entities.Cliente;
import com.lavamax.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:8080")
@Api(value = "Servicio REST para las clientees")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@ApiOperation("Rertorna una lista de publicidades")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> clientees = new ArrayList<>();
		clientees = clienteService.listar();
		return new ResponseEntity<List<Cliente>>(clientees, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> listarId(@PathVariable("id") Integer id) {
		Optional<Cliente> cliente = clienteService.listId(id);
		if (!cliente.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> registrar(@Valid @RequestBody Cliente cliente){
		Cliente clienteNew = new Cliente();
		clienteNew = clienteService.registrar(cliente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clienteNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<Cliente> actualizar(@Valid @RequestBody Cliente cliente) {		
		clienteService.modificar(cliente);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<Cliente> cliente = clienteService.listId(id);
		if (!cliente.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			clienteService.eliminar(id);
		}
	}
}
