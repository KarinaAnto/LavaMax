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
import com.lavamax.model.entities.Estado;
import com.lavamax.service.EstadoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = "http://localhost:8080")
@Api(value = "Servicio REST para los estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	@ApiOperation("Rertorna una lista de estados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Estado>> listar(){
		List<Estado> estados = new ArrayList<>();
		estados = estadoService.listar();
		return new ResponseEntity<List<Estado>>(estados, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Estado> listarId(@PathVariable("id") Integer id) {
		Optional<Estado> estado = estadoService.listId(id);
		if (!estado.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<Estado>(estado.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Estado> registrar(@Valid @RequestBody Estado estado){
		Estado estadoNew = new Estado();
		estadoNew = estadoService.registrar(estado);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estadoNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<Estado> actualizar(@Valid @RequestBody Estado estado) {		
		estadoService.modificar(estado);
		return new ResponseEntity<Estado>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<Estado> estado = estadoService.listId(id);
		if (!estado.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			estadoService.eliminar(id);
		}
	}
	
}












