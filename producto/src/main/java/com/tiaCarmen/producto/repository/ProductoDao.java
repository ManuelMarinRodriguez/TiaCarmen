package com.tiaCarmen.producto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tiaCarmen.producto.model.Producto;


/**
 * Clase de interfaz para consultar la 
 * entidad de producto
 * @author mmarinro
 *
 */
public interface  ProductoDao  extends CrudRepository<Producto, String>{

	
	@Modifying
	   @Query(value = "Select *  from PRODUCTO where CODIGOBARRA = :CODIGOBARRA", nativeQuery = true)
	   List<Producto> findByProducto(@Param("CODIGOBARRA") String CODIGOBARRA);
	
	
}