package com.tiaCarmen.venta.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tiaCarmen.venta.model.DetalleVoucher;

public interface DetalleVoucherDao extends CrudRepository<DetalleVoucher, Long> {

    @Query(value = "SELECT * FROM DETALLEVOUCHER  WHERE ID_VOUCHER = :ID_VOUCHER and ID_PRODUCTO = (Select ID_PRODUCTO from PRODUCTO where nombre = :NOMBRE) ", nativeQuery = true)
    ArrayList<DetalleVoucher> findByDetalleVoucherId(@Param("ID_VOUCHER") Long ID_VOUCHER, @Param("NOMBRE") String NOMBRE );
}
