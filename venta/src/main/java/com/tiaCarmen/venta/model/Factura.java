package com.tiaCarmen.venta.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Clase refleja la tabla Factura
 * @author mmarinro
 *
 */
@Data
@Entity
@Table(name = "FACTURA")
public class Factura {

	@Id
	@Column(name = "ID_FACTURA")
	private Long idFactura;
	
	
	@Column(name = "NUMEROVENTA")
	private Long numeroVenta;
	
	@Column(name = "RUT")
	private String rutEmpresa;
	
	
	public Factura() {

	}

	public Factura(Long idFactura, Long numeroVenta, String rutEmpresa) {
		this.idFactura = idFactura;

		this.numeroVenta = numeroVenta;
		
		this.rutEmpresa = rutEmpresa;

	}
	
}
