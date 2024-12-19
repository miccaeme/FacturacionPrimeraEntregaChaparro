package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "Clientes")

public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
	@Column(name= "Cliente_ID")
	private long id;
	
	@Column(name= "Nombre")
	
	private String nombre;
	private String apellido;
	
	@Column (unique = true, nullable = false) // va a ser unico y no nulo
	private int DNI;
	private String nDeCliente;
	
	@ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
	private List<Producto> productos = new ArrayList<>();
	
	private LocalDateTime createdAt;
	
	

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Cliente(String nombre, String apellido, int dNI, String nDeCliente) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
		DNI = dNI;
		this.nDeCliente = nDeCliente;
		
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getnDeCliente() {
		return nDeCliente;
	}

	public void setnDeCliente(String nDeCliente) {
		this.nDeCliente = nDeCliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	

}
