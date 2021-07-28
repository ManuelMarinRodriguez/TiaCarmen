package com.tiaCarmen.venta.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "VENTA")
public class Venta {

	@Id
	@Column(name = "NUMEROVENTA")
	private Long numero;

	@Column(name = "MONTOPAGAR")
	private Integer monto;

	@Column(name = "FECHAVENTA")
	private Date fecha;

	@Column(name = "TIPOVENTA")
	private Boolean tipo;

	@Column(name = "ID_VOUCHER")
	private Long voucherId;

	@Column(name = "ESTADO")
	private String estado;

	public Venta() {

	}

	public Venta(Long numero, Integer monto, Boolean tipo, Long voucherId) {
		this.numero = numero;
		estado = "1";
		this.monto = monto;
		this.tipo = tipo;
		this.voucherId = voucherId;
		fecha = new Date();
	}

	/**
	 * @return Long return the numero
	 */
	public Long getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Long numero) {
		this.numero = numero;
	}

	/**
	 * @return String return the monto
	 */
	public Integer getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	/**
	 * @return Date return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return Boolean return the tipo
	 */
	public Boolean isTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return Long return the voucherId
	 */
	public Long getVoucherId() {
		return voucherId;
	}

	/**
	 * @param voucherId the voucherId to set
	 */
	public void setVoucherId(Long voucherId) {
		this.voucherId = voucherId;
	}
}
