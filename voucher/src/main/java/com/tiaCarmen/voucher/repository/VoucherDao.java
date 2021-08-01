package com.tiaCarmen.voucher.repository;

import com.tiaCarmen.voucher.model.Voucher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
/**
 * Clase realiza la conexion ala tabla Voucher
 * @author mmarinro
 *
 */
public interface VoucherDao extends CrudRepository<Voucher, Long> {
    @Query(value = "SELECT * FROM VOUCHER v WHERE ID_VOUCHER = :idVoucher", nativeQuery = true)
    Voucher findByNumero(@Param("idVoucher") Long idVoucher);

	@Query(value = "SELECT MAX(ID_VOUCHER) + 1 FROM VOUCHER ", nativeQuery = true)
	Long getCorrelativo();
}
