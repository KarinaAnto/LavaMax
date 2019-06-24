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
import com.lavamax.model.entities.Publicacion;
import com.lavamax.service.PublicacionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/publicacion")
@CrossOrigin(origins = "http://localhost:8080")
@Api(value = "Servicio REST para las publicaciones")
public class PublicacionController {

	@Autowired
	private PublicacionService publicacionService;
	
	@ApiOperation("Rertorna una lista de publicidades")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Publicacion>> listar(){
		List<Publicacion> publicaciones = new ArrayList<>();
		publicaciones = publicacionService.listar();
		return new ResponseEntity<List<Publicacion>>(publicaciones, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Publicacion> listarId(@PathVariable("id") Integer id) {
		Optional<Publicacion> publicacion = publicacionService.listId(id);
		if (!publicacion.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<Publicacion>(publicacion.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Publicacion> registrar(@Valid @RequestBody Publicacion publicacion){
		Publicacion publicacionNew = new Publicacion();
		publicacionNew = publicacionService.registrar(publicacion);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(publicacionNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<Publicacion> actualizar(@Valid @RequestBody Publicacion publicacion) {		
		publicacionService.modificar(publicacion);
		return new ResponseEntity<Publicacion>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<Publicacion> publicacion = publicacionService.listId(id);
		if (!publicacion.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			publicacionService.eliminar(id);
		}
	}
}
