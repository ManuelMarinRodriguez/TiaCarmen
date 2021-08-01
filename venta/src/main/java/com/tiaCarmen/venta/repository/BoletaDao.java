package com.tiaCarmen.venta.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.tiaCarmen.venta.model.Boleta;

/**
 * Clase para conectar con la tabla Boleta
 * @author mmarinro
 *
 */
public interface BoletaDao extends CrudRepository<Boleta, Long> {

	

	@Query(value = "Select MAX(ID_BOLETA) + 1 as ID_BOLETA FROM BOLETA", nativeQuery = true)
	Long getBoleta();

	
}
