package com.tiaCarmen.venta.repository;

import java.util.ArrayList;

import com.tiaCarmen.venta.model.Producto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductoDao extends CrudRepository<Producto, Long> {

    @Query(value = "SELECT p.* FROM DETALLEVOUCHER d INNER JOIN PRODUCTO p ON d.ID_PRODUCTO = p.ID_PRODUCTO WHERE d.ID_VOUCHER = :voucherId", nativeQuery = true)
    ArrayList<Producto> findByVoucherId(@Param("voucherId") Long voucherId);
}
