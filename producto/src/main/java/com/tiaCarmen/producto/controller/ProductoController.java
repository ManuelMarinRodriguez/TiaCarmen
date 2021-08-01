package com.tiaCarmen.producto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiaCarmen.producto.service.ProductoService;
import com.tiaCarmen.producto.sto.ProductoDTO;



/**
 * 
 * @author mmarinro
 *
 */
@RestController
@CrossOrigin
public class ProductoController {
	
	@Autowired
	ProductoService service;
	/**
	 * Metodo para consultar por el nombre del
	 * Producto
	 * 
	 * @param json
	 * @return
	 */
	@PostMapping("/ConsultaNombreProducto")
	public ProductoDTO consultaClientes(@RequestBody String json) {
		
		System.out.println("Verificar algo : " + json);
		return service.validaProducto(json);
	}

}
