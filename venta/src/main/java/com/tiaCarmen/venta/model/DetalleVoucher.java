package com.tiaCarmen.venta.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
/**
 * Clase para conectar con la tabla DETALLEVOUCHER
 * 
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
    private Long id_voucher;
    
    @Id
    @Column(name = "ID_PRODUCTO")
    private int id_producto;
    
    @Column(name = "CANTIDAD")
    private double cantidad;

   
   

}