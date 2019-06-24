package com.lavamax.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lavanderia")
public class Lavanderia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;
	
	@Column(name = "telefono", nullable = false, length = 70)
	private String telefono;
	
	@Column(name = "cantidadLocales", nullable = false, length = 70)
	private Integer cantidadLocales;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getCantidadLocales() {
		return cantidadLocales;
	}

	public void setCantidadLocales(Integer cantidadLocales) {
		this.cantidadLocales = cantidadLocales;
	}
	
	
}
