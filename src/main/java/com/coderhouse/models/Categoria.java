package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name= "Categorias")

public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
	
	@Column(name= "ID_Categoria")
	private long id;
	@Column(unique =true, nullable = false, name = "Nombre_Categoria")
	private String nombre;
	@Column(name = "Descripcion_Categoria")
	private String descripcion;
	
	@OneToMany(mappedBy="categoria", fetch = FetchType.EAGER)
	
	private List<Producto> productos = new ArrayList<>();
	
	
	
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria( String nombre, String descripcion) {
		this();
		
		this.nombre = nombre;
		this.descripcion = descripcion;
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
	
	
	
}
