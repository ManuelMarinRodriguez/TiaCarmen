package com.tiaCarmen.venta.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * Clase refleja la tabla Voucher
 * @author mmarinro
 *
 */
@Data
@Entity
@Table(name = "VOUCHER")
@IdClass(Voucher.class)
public class Voucher  implements Serializable {
	 

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @Column(name = "ID_VOUCHER")
	    private Long id_voucher;
	    
   

	}