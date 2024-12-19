package com.coderhouse.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name= "Ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
	
	@Column(name= "ID_Venta")
	private long idVenta;
	@Column(name = "Nombre_Cliente")
	private String nombreCliente;
	@Column(name = "FechaVenta")
	private LocalDateTime createdAt;
	@Column(name = "MontoTotal")
	private Integer montoTotal;
	@Column(name = "Estado_Venta")
	private String estado;
	@Column(name = "Metodo_Pago")
	private String metodoDePago;
	
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venta(long idVenta, String nombreCliente, LocalDateTime createdAt, Integer montoTotal, String estado,
			String metodoDePago) {
		this();
		this.idVenta = idVenta;
		this.nombreCliente = nombreCliente;
		this.createdAt = createdAt;
		this.montoTotal = montoTotal;
		this.estado = estado;
		this.metodoDePago = metodoDePago;
	}

	public long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Integer montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}
	
	
	
}
