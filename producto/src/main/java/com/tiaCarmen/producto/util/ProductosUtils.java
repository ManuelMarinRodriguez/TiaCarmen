package com.tiaCarmen.producto.util;

public class ProductosUtils {

	public static String calcularPrecio(String precioVenta, String Cantidad) {


		int precioVentaF = Integer.parseInt(precioVenta);
		
		double cantidadProducto = Double.parseDouble(Cantidad);
		
		
		int PrecioFinal = (int) (precioVentaF * cantidadProducto);
		String PrecioFinal2 = Integer.toString(PrecioFinal);
		
		
		return PrecioFinal2;
	}
	
	


}
