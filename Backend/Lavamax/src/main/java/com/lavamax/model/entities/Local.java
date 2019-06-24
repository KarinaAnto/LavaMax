package com.lavamax.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Local")
public class Local {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;
	
	@Column(name = "direccion", nullable = false, length = 70)
	private String direccion;
	
	@Column(name = "telefono", nullable = false, length = 70)
	private String telefono;
	
	@Column(name = "celular", nullable = false, length = 70)
	private String celular;
	
	@Column(name = "latitud", nullable = false, length = 70)
	private Float latitud;
	
	@Column(name = "longitud", nullable = false, length = 70)
	private Float longitud;
	
	@ManyToOne
	@JoinColumn(name = "lavanderia_id")
	private Lavanderia lavanderia;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Float getLatitud() {
		return latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getLongitud() {
		return longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Lavanderia getLavanderia() {
		return lavanderia;
	}

	public void setLavanderia(Lavanderia lavanderia) {
		this.lavanderia = lavanderia;
	}
	
	
}
