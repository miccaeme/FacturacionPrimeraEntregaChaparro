package com.coderhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Categoria;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;

@SpringBootApplication
public class PrimeraEntregaApplication implements CommandLineRunner{
	
	@Autowired //inyecta una clase para que los metodos sean accesibles
	private DaoFactory dao;
	
	public static void main(String[] args) {
		SpringApplication.run(PrimeraEntregaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			Categoria categoria1 = new Categoria("Curso", "Aca podes encontrar cursos de programacion");
			Categoria categoria2 = new Categoria("Accesorios", "Aca podes encontrar Merchandasing de nuestra Marca");
			Categoria categoria3 = new Categoria("Elector", "Aca podes encontrar productos de electronica");
			
			Producto producto1 = new Producto("Curso_Java");
			Producto producto2 = new Producto("Curso_HTML5");
			Producto producto3 = new Producto("Curso_CSS3");
			
			Cliente cliente1 = new Cliente("Juan","Perez",470,"001");
			Cliente cliente2 =new Cliente("Milagros","Padua",43,"002");
			Cliente cliente3 =new Cliente("Luca","Beati",2350,"003");
			
			dao.persistirCliente(cliente1);
			dao.persistirCliente(cliente2);
			dao.persistirCliente(cliente3);
			
			dao.persistirProducto(producto1);
			dao.persistirProducto(producto2);
			dao.persistirProducto(producto3);
			
			dao.persistirCategoria(categoria1);
			dao.persistirCategoria(categoria2);
			dao.persistirCategoria(categoria3);
			
			dao.asignarCategoriaAProducto(producto1.getId(), categoria1.getId());
			dao.asignarCategoriaAProducto(producto2.getId(), categoria2.getId());
			dao.asignarCategoriaAProducto(producto3.getId(), categoria3.getId());
			
		}catch (Exception e){
			e.printStackTrace(System.err);
		}
		
	}
	

}
