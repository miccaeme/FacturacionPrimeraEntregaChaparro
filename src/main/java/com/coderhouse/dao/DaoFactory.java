package com.coderhouse.dao;

import org.springframework.stereotype.Service;

import com.coderhouse.models.Categoria;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class DaoFactory {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional //Verifica que el metodo tiene que ejecutarse dentro de una transacion.
	public void persistirCliente(Cliente cliente){
		em.persist(cliente);
		
	}
	
	@Transactional 
	public void persistirProducto(Producto producto){
		em.persist(producto);
	}
	
	@Transactional 
	public void persistirCategoria(Categoria categoria){
		em.persist(categoria);
	}
	
	//Metodo para juntar Categoria y Producto
	
	@Transactional
	public Producto getProductoById(Long Producto_ID) throws Exception {
		try {
			TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p WHERE p.id=:id", Producto.class);
			return query.setParameter("id", Producto_ID).getSingleResult();
		}catch (Exception e) {
			throw new Exception ("El curso no existe");
		}
	}
	
	@Transactional
	public Categoria getCategoriaById(Long Categoria_ID) throws Exception {
		try {
			TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c WHERE c.id=:id", Categoria.class);
			return query.setParameter("id", Categoria_ID).getSingleResult();
		}catch (Exception e) {
			throw new Exception ("La categoria no existe");
		}
	}
	@Transactional
	public void asignarCategoriaAProducto(Long Producto_ID, Long ID_Categoria) throws Exception {
		//Obtener el producto por el ID
		Producto producto = getProductoById (Producto_ID);
		if(producto == null) {
			throw new Exception("El producto con ID: " + Producto_ID + " no Existe");
		}
		//Obtener el producto por el ID
				Categoria categoria = getCategoriaById (ID_Categoria);
				if(categoria == null) {
					throw new Exception("El producto con ID: " + ID_Categoria + " no Existe");
				}
		
		producto.setCategoria(categoria);
		
		//Persistir Datos
		
		em.merge(producto);
	}
}
