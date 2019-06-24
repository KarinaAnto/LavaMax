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
import com.lavamax.model.entities.DetalleProducto;
import com.lavamax.service.DetalleProductoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/detalleProducto")
@CrossOrigin(origins = "http://localhost:8080")
@Api(value = "Servicio REST para las detalleProductoes")
public class DetalleProductoController {

	@Autowired
	private DetalleProductoService detalleProductoService;
	
	@ApiOperation("Rertorna una lista de publicidades")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DetalleProducto>> listar(){
		List<DetalleProducto> detalleProductoes = new ArrayList<>();
		detalleProductoes = detalleProductoService.listar();
		return new ResponseEntity<List<DetalleProducto>>(detalleProductoes, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DetalleProducto> listarId(@PathVariable("id") Integer id) {
		Optional<DetalleProducto> detalleProducto = detalleProductoService.listId(id);
		if (!detalleProducto.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<DetalleProducto>(detalleProducto.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<DetalleProducto> registrar(@Valid @RequestBody DetalleProducto detalleProducto){
		DetalleProducto detalleProductoNew = new DetalleProducto();
		detalleProductoNew = detalleProductoService.registrar(detalleProducto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(detalleProductoNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<DetalleProducto> actualizar(@Valid @RequestBody DetalleProducto detalleProducto) {		
		detalleProductoService.modificar(detalleProducto);
		return new ResponseEntity<DetalleProducto>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<DetalleProducto> detalleProducto = detalleProductoService.listId(id);
		if (!detalleProducto.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			detalleProductoService.eliminar(id);
		}
	}
}
