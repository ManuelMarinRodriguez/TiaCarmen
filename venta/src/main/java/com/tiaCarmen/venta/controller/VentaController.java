package com.tiaCarmen.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/consultaventa/{numero}")
	public VentaDTO consultaVenta(@PathVariable Long numero) {
		System.out.println("Verufucar ConsultaVenta");
		return service.getVenta(numero);
	}

	@PostMapping("/agregarventa")
	public String AgregarEmpresa(@RequestBody String json) {

		System.out.println("Verificar algo : " + json);
		return service.agregarVenta(json);
	}
}
