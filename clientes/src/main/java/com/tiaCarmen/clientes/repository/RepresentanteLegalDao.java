package com.tiaCarmen.clientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tiaCarmen.clientes.model.RepresentanteLegal;

/**
 * Clase para conectar con la BD
 * y con la tabla REPRESENTANTELEGAL
 * @author mmarinro
 *
 */
public interface RepresentanteLegalDao extends CrudRepository<RepresentanteLegal, String>{

	
	@Modifying
	   @Query(value = "SELECT * FROM REPRESENTANTELEGAL WHERE RUT_REPRESENTANTE_LEGAL = :rut", nativeQuery = true)
	   List<RepresentanteLegal> findByRepLegalRut(@Param("rut") String rut);
	
	
}
