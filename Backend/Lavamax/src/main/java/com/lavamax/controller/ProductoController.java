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
import com.lavamax.model.entities.Producto;
import com.lavamax.service.ProductoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:8080")
@Api(value = "Servicio REST para las productoes")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@ApiOperation("Rertorna una lista de publicidades")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> listar(){
		List<Producto> productoes = new ArrayList<>();
		productoes = productoService.listar();
		return new ResponseEntity<List<Producto>>(productoes, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Producto> listarId(@PathVariable("id") Integer id) {
		Optional<Producto> producto = productoService.listId(id);
		if (!producto.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<Producto>(producto.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Producto> registrar(@Valid @RequestBody Producto producto){
		Producto productoNew = new Producto();
		productoNew = productoService.registrar(producto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productoNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<Producto> actualizar(@Valid @RequestBody Producto producto) {		
		productoService.modificar(producto);
		return new ResponseEntity<Producto>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<Producto> producto = productoService.listId(id);
		if (!producto.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			productoService.eliminar(id);
		}
	}
}
