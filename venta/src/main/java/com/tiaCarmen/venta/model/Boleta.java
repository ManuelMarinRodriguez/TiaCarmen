package com.tiaCarmen.venta.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entidad que representa a taba Boleta
 * @author mmarinro
 *
 */
@Data
@Entity
@Table(name = "BOLETA")
public class Boleta {

	@Id
	@Column(name = "ID_BOLETA")
	private Long idBoleta;
	
	
	@Column(name = "NUMEROVENTA")
	private Long numeroVenta;
	
	
	public Boleta() {

	}

	public Boleta(Long idBoleta, Long numeroVenta) {
		this.idBoleta = idBoleta;

		this.numeroVenta = numeroVenta;

	}
	
}
