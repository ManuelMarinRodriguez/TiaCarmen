package com.tiaCarmen.voucher.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
/**
 * Clase representa a la tabla DetalleVoucher
 * @author mmarinro
 *
 */
@Data
@Entity
@Table(name = "DETALLEVOUCHER")
@IdClass(DetalleVoucher.class)
public class DetalleVoucher implements Serializable {
  

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "ID_VOUCHER")
    private Long idVoucher;

    @Id
    @Column(name = "ID_PRODUCTO")
    private Long idProducto;

    @Column(name = "CANTIDAD")
    private double cantidad;

    public DetalleVoucher() {

    }

    public DetalleVoucher(Long idVoucher, Long idProducto, double cantidad) {
        this.idVoucher = idVoucher;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public double getCantidad() {
        return cantidad;
    }
}