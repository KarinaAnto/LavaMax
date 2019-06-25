package com.lavamax.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	
	@Column(name = "preciokilo", nullable = false, length = 70)
	private Float precioKilo;
		
	@ManyToOne
	@JoinColumn(name = "catalogo_id")
	private Catalogo catalogo;
	
	@OneToMany(mappedBy = "producto", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<DetalleProducto> detalles;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}


	public Float getPrecioKilo() {
		return precioKilo;
	}

	public void setPrecioKilo(Float precioKilo) {
		this.precioKilo = precioKilo;
	}

	public List<DetalleProducto> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleProducto> detalles) {
		this.detalles = detalles;
	}	
	
}
