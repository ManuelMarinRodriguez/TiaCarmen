package com.tiaCarmen.venta.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DETALLEVOUCHER")
@IdClass(DetalleVoucher.class)
public class DetalleVoucher implements Serializable {
 

	@Id
    @Column(name = "ID_VOUCHER")
    private Long id_voucher;
    
    @Id
    @Column(name = "ID_PRODUCTO")
    private int id_producto;
    
    @Column(name = "CANTIDAD")
    private int cantidad;

   
   

}