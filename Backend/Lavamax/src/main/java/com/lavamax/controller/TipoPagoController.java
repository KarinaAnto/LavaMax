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
import com.lavamax.model.entities.TipoPago;
import com.lavamax.service.TipoPagoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/tipoPago")
@CrossOrigin(origins = "http://localhost:8080")
@Api(value = "Servicio REST para los tipos de pago")
public class TipoPagoController {

	@Autowired
	private TipoPagoService tipopagoService;
	
	@ApiOperation("Rertorna una lista de pacientes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoPago>> listar(){
		List<TipoPago> tipospago = new ArrayList<>();
		tipospago = tipopagoService.listar();
		return new ResponseEntity<List<TipoPago>>(tipospago, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TipoPago> listarId(@PathVariable("id") Integer id) {
		Optional<TipoPago> tipopago = tipopagoService.listId(id);
		if (!tipopago.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<TipoPago>(tipopago.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TipoPago> registrar(@Valid @RequestBody TipoPago tipopago){
		TipoPago tipopagoNew = new TipoPago();
		tipopagoNew= tipopagoService.registrar(tipopago);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tipopagoNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<TipoPago> actualizar(@Valid @RequestBody TipoPago tipopago) {		
		tipopagoService.modificar(tipopago);
		return new ResponseEntity<TipoPago>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<TipoPago> tipopago = tipopagoService.listId(id);
		if (!tipopago.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			tipopagoService.eliminar(id);
		}
	}
}












