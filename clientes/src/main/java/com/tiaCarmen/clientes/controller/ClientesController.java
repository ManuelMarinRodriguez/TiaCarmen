package com.tiaCarmen.clientes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiaCarmen.clientes.dto.ClientesDTO;
import com.tiaCarmen.clientes.dto.EmpresaClienteDto;
import com.tiaCarmen.clientes.dto.RepresentanteLegalDTO;
import com.tiaCarmen.clientes.service.ClientesService;

/**
 * 
 * @author mmarinro
 *
 */
@RestController
@CrossOrigin
public class ClientesController {

	@Autowired
	ClientesService service;
	
	/**
	 * Metodo que responde existencia de empresa
	 * y representante legal
	 * @param json
	 * @return
	 */
	@PostMapping("/ConsultaClientes")
	public ClientesDTO consultaClientes(@RequestBody String json) {
		
			
		return service.validaClientes(json);
	}
	
	/**
	 * Metodo para agregar a cliente empresa
	 * @param json
	 * @return
	 */
	@PostMapping("/AgregarEmpresa")
	public EmpresaClienteDto AgregarEmpresa(@RequestBody String json) {
		
		
		 return service.agregarEmpresa(json);
	}
	
	/**
	 * Metodo para agregar a representante legal
	 * @param json
	 * @return
	 */
	@PostMapping("/AgregarRepLegal")
	public RepresentanteLegalDTO AgregarRepLegal(@RequestBody String json) {
		
		System.out.println("Verificar algo : " + json);
		return service.agregarRepLegal(json);
	}

}
