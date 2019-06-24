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
@Table(name = "Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "detalle_id")
	private DetalleProducto detalleProducto;
	
	@ManyToOne
	@JoinColumn(name = "catalogo_id")
	private Catalogo catalogo;

	@ManyToOne
	@JoinColumn(name = "servicio_id")
	private Servicio servicio;
	
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

	public DetalleProducto getDetalleProducto() {
		return detalleProducto;
	}

	public void setDetalleProducto(DetalleProducto detalleProducto) {
		this.detalleProducto = detalleProducto;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}	
}
