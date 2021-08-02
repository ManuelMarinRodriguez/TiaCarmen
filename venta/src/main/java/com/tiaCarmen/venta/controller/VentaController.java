package com.tiaCarmen.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiaCarmen.venta.dto.ResultadoDTO;
import com.tiaCarmen.venta.dto.VentaDTO;
import com.tiaCarmen.venta.service.VentaService;

/**
 * 
 * @author msagredo
 *
 */
@RestController
@CrossOrigin
public class VentaController {

	@Autowired
	VentaService service;
	
	/**
	 * Consta la venta por el numero de boleta
	 * @param numero
	 * @return
	 */
	@GetMapping("/consultaventa/{numero}")
	public VentaDTO consultaVenta(@PathVariable Long numero) {
		System.out.println("Verufucar ConsultaVenta");
		return service.getVenta(numero);
	}

	/**
	 * Agrega una venta nueva
	 * @param json
	 * @return
	 */
	@PostMapping("/agregarventa")
	public ResultadoDTO AgregarVenta(@RequestBody String json) {

		return service.agregarVenta(json);
	}
	
	/**
	 * Paga una venta por boleta
	 * @param json
	 * @return
	 */
	@PostMapping("/pagarBoleta")
	public ResultadoDTO PagarBoleta(@RequestBody String json) {
		
		return  service.pagarBoleta(json);
		
	}
	
	/**
	 * Paga una venta por factura
	 * @param json
	 * @return
	 */
	@PostMapping("/pagarFactura")
	public ResultadoDTO PagarFactura(@RequestBody String json) {
		
		return  service.pagarFactura(json);
		
	}
}
