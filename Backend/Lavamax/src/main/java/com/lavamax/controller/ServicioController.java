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
import com.lavamax.model.entities.Servicio;
//import com.lavamax.service.EstadoService;
//import com.lavamax.service.LocalService;
//import com.lavamax.service.PagoService;
import com.lavamax.service.ServicioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/servicios")
@CrossOrigin(origins = "http://localhost:8080")
@Api(value = "Servicio REST para los servicios")
public class ServicioController {

	@Autowired
	private ServicioService servicioService;
	
	//@Autowired
	//private ClienteService clienteService;
	
	//@Autowired
	//private PagoService pagoService;
	
	//@Autowired
	//private LocalService localService;
	
	//@Autowired
	//private EstadoService estadoService;
	
	@ApiOperation("Rertorna una lista de servicios")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Servicio>> listar(){
		List<Servicio> servicios = new ArrayList<>();
		servicios = servicioService.listar();
		return new ResponseEntity<List<Servicio>>(servicios, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Servicio> listarId(@PathVariable("id") Integer id) {
		Optional<Servicio> servicio = servicioService.listId(id);
		if (!servicio.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<Servicio>(servicio.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Servicio> registrar(@Valid @RequestBody Servicio servicio){
		Servicio servicioNew = new Servicio();
		servicioNew= servicioService.registrar(servicio);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(servicioNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<Servicio> actualizar(@Valid @RequestBody Servicio servicio) {		
		servicioService.modificar(servicio);
		return new ResponseEntity<Servicio>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<Servicio> servicio = servicioService.listId(id);
		if (!servicio.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			servicioService.eliminar(id);
		}
	}
	
	
}










