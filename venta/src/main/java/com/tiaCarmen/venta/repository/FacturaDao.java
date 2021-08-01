package com.tiaCarmen.venta.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.tiaCarmen.venta.model.Factura;

/**
 * Interfaz para consultar la tabla Factura
 * @author mmarinro
 *
 */
public interface FacturaDao extends CrudRepository<Factura, Long> {

	

	@Query(value = "Select MAX(ID_FACTURA) + 1 as ID_FACTURA FROM Factura", nativeQuery = true)
	Long getFactura();

	
}
