package com.lavamax.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Servicio")
public class Servicio {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "inicio", nullable = false, length = 70)
	private Date inicio;
	
	@Column(name = "fin", nullable = false, length = 70)
	private Date fin;
	
	//@ManyToOne
	//@JoinColumn(name = "cliente_id")
	//private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "pago_id")
	private Pago pago;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "local_id")
	private Local local;
	
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
