package com.tiaCarmen.clientes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@PostMapping("/ConsultaClientes")
	public ClientesDTO consultaClientes(@RequestBody String json, HttpServletRequest request, HttpServletResponse response,
			ClientesDTO vo) {
		
		System.out.println("Verificar algo : " + json);
		System.out.println("Verificar algo2 : " + vo.getRutEmpresa());
		System.out.println("Verificar algo3 : " + vo.getRutRepresentanteLegal());
		
		return service.validaClientes(vo);
	}
	
	
	
	
	@PostMapping("/AgregarEmpresa")
	public EmpresaClienteDto AgregarEmpresa(@RequestBody String json, HttpServletRequest request, HttpServletResponse response,
			EmpresaClienteDto vo) {
		
		System.out.println("Verificar algo : " + json);
		 return service.agregarEmpresa(vo);
	}
	
	
	@PostMapping("/AgregarRepLegal")
	public RepresentanteLegalDTO AgregarRepLegal(@RequestBody String json, HttpServletRequest request, HttpServletResponse response,
			RepresentanteLegalDTO vo) {
		
		System.out.println("Verificar algo : " + json);
		return service.agregarRepLegal(vo);
	}

}
