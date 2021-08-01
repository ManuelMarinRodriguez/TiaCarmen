package com.tiaCarmen.venta.Util;

/**
 * Clase que contiene metodos genericos
 * @author mmarinro
 *
 */
public class Utils {

	
	public static Long ValidarVacio(Long valor) {
		
		if (valor != null ) {
			
			System.out.println("Valor viene completo");
		}else
		{
			System.out.println("No vienen datos desde BD");
			valor = (long) 1;
		}
		
		return valor;
	}
	
}
