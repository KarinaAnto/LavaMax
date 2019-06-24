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
@Table(name = "DetalleProducto")
public class DetalleProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cantidad", nullable = false, length = 70)
	private Integer cantidad;
	
	@Column(name = "preciokilo", nullable = false, length = 70)
	private Float precioKilo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getPrecioKilo() {
		return precioKilo;
	}

	public void setPrecioKilo(Float precioKilo) {
		this.precioKilo = precioKilo;
	}
	
}
