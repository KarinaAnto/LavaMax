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
import com.lavamax.model.entities.Catalogo;
import com.lavamax.service.CatalogoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/lavanderias/{lavanderia}/locales/{local}/catalogos")
//@CrossOrigin(origins = "http://localhost:8080")
@Api(value = "Servicio REST para las catalogoes")
public class CatalogoController {

	@Autowired
	private CatalogoService catalogoService;
	
//	@ApiOperation("Rertorna una lista de catalogos")
//	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Catalogo>> listar(){
//		List<Catalogo> catalogoes = new ArrayList<>();
//		catalogoes = catalogoService.listar();
//		return new ResponseEntity<List<Catalogo>>(catalogoes, HttpStatus.OK);
//	}
	@ApiOperation("Rertorna una lista de catalogos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Catalogo>> listLocalId(@PathVariable("local") Integer localId){
		List<Catalogo> catalogos = new ArrayList<>();
		catalogos = catalogoService.listLocalId(localId);
		return new ResponseEntity<List<Catalogo>>(catalogos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Catalogo> listarId(@PathVariable("id") Integer id) {
		Optional<Catalogo> catalogo = catalogoService.listId(id);
		if (!catalogo.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<Catalogo>(catalogo.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Catalogo> registrar(@Valid @RequestBody Catalogo catalogo){
		Catalogo catalogoNew = new Catalogo();
		catalogoNew = catalogoService.registrar(catalogo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(catalogoNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<Catalogo> actualizar(@Valid @RequestBody Catalogo catalogo) {		
		catalogoService.modificar(catalogo);
		return new ResponseEntity<Catalogo>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<Catalogo> catalogo = catalogoService.listId(id);
		if (!catalogo.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			catalogoService.eliminar(id);
		}
	}
}
