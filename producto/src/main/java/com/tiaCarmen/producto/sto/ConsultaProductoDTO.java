package com.tiaCarmen.producto.sto;

import lombok.Data;
/**
 * Entidad que almacena los datos de entrada 
 * del Json
 * @author mmarinro
 *
 */
@Data
public class ConsultaProductoDTO {
	
	
	/**the CodigoBarra**/
	private String CodigoBarra;
	
	/**the CantidadProducto**/
	private String CantidadProducto;
	
}
