package com.tiaCarmen.clientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tiaCarmen.clientes.model.Empresa;

public interface EmpresaDao extends CrudRepository<Empresa, String>{

	
	@Modifying
	   @Query(value = "SELECT * FROM EMPRESA WHERE RUT = :rut", nativeQuery = true)
	   List<Empresa> findByCliRut(@Param("rut") String rut);
	
	
}
