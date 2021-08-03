package com.tiaCarmen.venta.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tiaCarmen.venta.model.Venta;

/**
 * Interfaz para consultar la tabla venta
 * @author mmarinro
 *
 */
public interface VentaDao extends CrudRepository<Venta, Long> {

	@Query(value = "SELECT * FROM VENTA v WHERE NUMEROVENTA = :numero", nativeQuery = true)
	Venta findByNumero(@Param("numero") Long numero);

	@Query(value = "SELECT max(NUMEROVENTA) + 1 FROM VENTA", nativeQuery = true)
	Long getNumero();

	
	@Query(value = "Select * from VENTA where ID_VOUCHER = :NUMEROVENTA and ESTADO = 0", nativeQuery = true)
	List<Venta> findByVenta(@Param("NUMEROVENTA") Long NUMEROVENTA);
	
	@Modifying
	@Transactional
	@Query("UPDATE Venta SET TIPOVENTA = 1,  ESTADO = 1 where NUMEROVENTA = :NUMEROVENTA and ESTADO = 0")
	void pagarBoleta(@Param("NUMEROVENTA") Long NUMEROVENTA);
	
	
	@Modifying
	@Transactional
	@Query("UPDATE Venta SET TIPOVENTA = 2,  ESTADO = 1 where NUMEROVENTA = :NUMEROVENTA and ESTADO = 0")
	void pagarFactura(@Param("NUMEROVENTA") Long NUMEROVENTA);
	
	
}
