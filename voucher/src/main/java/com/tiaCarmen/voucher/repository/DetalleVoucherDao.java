package com.tiaCarmen.voucher.repository;

import com.tiaCarmen.voucher.model.DetalleVoucher;

import org.springframework.data.repository.CrudRepository;
/**
 * Clase realiza la conexion ala tabla DetalleVoucher
 * @author mmarinro
 *
 */
public interface DetalleVoucherDao extends CrudRepository<DetalleVoucher, Long> {

}
