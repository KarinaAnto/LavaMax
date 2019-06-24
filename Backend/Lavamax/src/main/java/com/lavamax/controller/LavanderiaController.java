package com.lavamax.controller;

import javax.validation.Valid;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.lavamax.service.LavanderiaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/lavanderias")
@CrossOrigin(origins = "http://localhost:8080")
@Api(value = "Servicio REST para las lavanderias")
public class LavanderiaController {

	@Autowired
	private LavanderiaService lavanderiaService;

	@ApiOperation("Rertorna una lista de lavanderias")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Lavanderia>> listar() {
		List<Lavanderia> lavanderias = new ArrayList<>();
		lavanderias = lavanderiaService.listar();
		return new ResponseEntity<List<Lavanderia>>(lavanderias, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Lavanderia> listarId(@PathVariable("id") Integer id){
		Optional<Lavanderia> lavanderia = lavanderiaService.listId(id);
		if (!lavanderia.isPresent()) {
			throw new ModeloNotFoundException("ID" + id);
		}
		return new ResponseEntity<Lavanderia>(lavanderia.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Lavanderia> registrar(@Valid @RequestBody Lavanderia lavanderia){
		Lavanderia lavanderiaNew = new Lavanderia();
		lavanderiaNew = lavanderiaService.registrar(lavanderia);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lavanderiaNew.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Lavanderia> actualizar(@Valid @RequestBody Lavanderia lavanderia) {		
		lavanderiaService.modificar(lavanderia);
		return new ResponseEntity<Lavanderia>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<Lavanderia> lavanderia = lavanderiaService.listId(id);
		if (!lavanderia.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			lavanderiaService.eliminar(id);
		}
	}
}
