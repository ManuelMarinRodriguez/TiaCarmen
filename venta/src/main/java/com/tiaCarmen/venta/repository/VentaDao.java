package com.tiaCarmen.venta.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tiaCarmen.venta.model.Venta;

public interface VentaDao extends CrudRepository<Venta, Long> {

	@Query(value = "SELECT * FROM VENTA v WHERE NUMEROVENTA = :numero", nativeQuery = true)
	Venta findByNumero(@Param("numero") Long numero);

	@Query(value = "SELECT max(NUMEROVENTA) + 1 FROM VENTA", nativeQuery = true)
	Long getNumero();
}
