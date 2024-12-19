package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "Productos")

public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
	
	@Column(name= "Producto_ID")
	private long id;
	@Column(name = "Nombre_Producto")
	private String nombre;
	private String descripcion;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "cliente_producto", 
			joinColumns = @JoinColumn(name= "cliente_id"),
			inverseJoinColumns = @JoinColumn (name="producto_id")
			)
	
	private List<Cliente> clientes = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria ;
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto( String nombre) {
		this();
		this.nombre = nombre;
		// TODO Auto-generated constructor stub
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
