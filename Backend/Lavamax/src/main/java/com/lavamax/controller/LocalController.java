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
import com.lavamax.model.entities.Lavanderia;
import com.lavamax.model.entities.Local;
import com.lavamax.service.LavanderiaService;
import com.lavamax.service.LocalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/lavanderias/{lavanderia}/locales")
//@CrossOrigin(origins = "http://localhost:8080")
@Api(value = "Servicio REST para los locales")
public class LocalController {

	@Autowired
	private LocalService localService;
	
	@Autowired
	private LavanderiaService lavanderiaService;
	
	@ApiOperation("Rertorna una lista de pacientes")
//	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Local>> listar(){
//		List<Local> locales = new ArrayList<>();
//		locales = localService.listar();
//		return new ResponseEntity<List<Local>>(locales, HttpStatus.OK);
//	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Local>> listarPorLavanderia
	(@PathVariable("lavanderia") Integer lavanderia){
	//(@Valid @RequestBody int idLavanderia){
		List<Local> locales = new ArrayList<>();
		locales = localService.listLocalByLavanderiaId(lavanderia);
		return new ResponseEntity<List<Local>>(locales, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Local> listarId(@PathVariable("id") Integer id) {
		Optional<Local> local = localService.listId(id);
		if (!local.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<Local>(local.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Local> registrar(@Valid @RequestBody Local local){
		Local localNew = new Local();
		localNew= localService.registrar(local);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(localNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<Local> actualizar(@Valid @RequestBody Local local) {		
		localService.modificar(local);
		return new ResponseEntity<Local>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<Local> local = localService.listId(id);
		if (!local.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			localService.eliminar(id);
		}
	}
	
}














