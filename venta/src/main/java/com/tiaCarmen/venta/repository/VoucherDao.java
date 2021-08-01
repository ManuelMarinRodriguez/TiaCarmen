package com.tiaCarmen.venta.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tiaCarmen.venta.model.Voucher;

/**
 * Interfaz para consultar la tabla
 * Voucher
 * @author mmarinro
 *
 */
public interface VoucherDao extends CrudRepository<Voucher, Long> {
	
	
	@Query(value = "(Select MAX(ID_VOUCHER) + 1 as ID_VOUCHER FROM VOUCHER)", nativeQuery = true)
    ArrayList<Voucher> findByMaxVoucher( );

	
	
	 @Modifying(clearAutomatically = true)
	 @Transactional
	 @Query(value = "Insert  INTO VOUCHER  VALUES (:ID_VOUCHER)" , nativeQuery = true)
	 public void saveMaxVoucher(@Param("ID_VOUCHER") Long ID_VOUCHER);
}
