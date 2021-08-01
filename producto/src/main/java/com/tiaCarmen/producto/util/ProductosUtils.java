package com.tiaCarmen.producto.util;
/**
 * 
 * @author mmarinro
 *
 */
public class ProductosUtils {

	/**
	 * Calcula el monto a pagar del producto
	 * @param precioVenta
	 * @param Cantidad
	 * @return
	 */
	public static String calcularPrecio(String precioVenta, String Cantidad) {


		int precioVentaF = Integer.parseInt(precioVenta);
		
		double cantidadProducto = Double.parseDouble(Cantidad);
		
		
		int PrecioFinal = (int) (precioVentaF * cantidadProducto);
		String PrecioFinal2 = Integer.toString(PrecioFinal);
		
		
		return PrecioFinal2;
	}
	
	


}
