package com.tiaCarmen.producto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

/**
 * Entidad para consultar la tabla de Producto
 * @author mmarinro
 *
 */
@Data
@Entity
@Table(name="PRODUCTO")
public class Producto {
	
	
	@Id
	@Column(name="ID_PRODUCTO")
	private String idProducto;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="CODIGOBARRA")
	private String codigoBarra;
	
	@Column(name="PRECIOCOSTO")
	private String precioCosto;

	@Column(name="PRECIOVENTA")
	private String precioVenta;

	
}
