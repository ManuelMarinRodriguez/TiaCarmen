package com.tiaCarmen.FrontEndCarniceria.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tiaCarmen.FrontEndCarniceria.service.FrontService;



@Controller
public class FrontController {
	
	@Autowired
	FrontService service;
	
	@PostMapping("/BusquedaProductos")
	public ModelAndView operationGet(HttpServletRequest request, HttpServletResponse response) {
	
		
		return service.busquedaProducto(request, response);
	}
	
	/**
	 * Descargar comprobante.
	 *
	 * @param request the request
	 * @param httpServletResponse the http servlet response
	 */
	@PostMapping("PagarBoleta")
	public void descargarComprobante(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		System.out.println("Saludos Mundo Cruel");
		service.pagarBoleta(request, httpServletResponse);
		}
	
	
	/**
	 * Descargar comprobante.
	 *
	 * @param request the request
	 * @param httpServletResponse the http servlet response
	 */
	@PostMapping("/PagarBoletaFinal")
	public void pagarBoletaFinal(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		System.out.println("Saludos Mundo Cruel /PagarBoletaFinal");
		//service.pagarBoleta(request, httpServletResponse);
		}
	
	
	

	@PostMapping("/BusquedaClientes")
	public ModelAndView BusquedaClientes(HttpServletRequest request, HttpServletResponse response) {
	
		
		return service.BusquedaClientes(request, response);
	}
	
	
	/**
	 * Descargar comprobante.
	 *
	 * @param request the request
	 * @param httpServletResponse the http servlet response
	 */
	@PostMapping("/BusquedaClientesMS")
	public ModelAndView BusquedaClientesMS(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		System.out.println("Saludos Mundo Cruel /BusquedaClientesMS");
		
		System.out.println("Verificar BusquedaClientesMS: " +  request.getParameter("BusquedaEmpresa"));
		System.out.println("Verificar BusquedaClientesMS: " +  request.getParameter("BusquedaRepLegal"));
		
		
		return service.BusquedaClientesMS(request, httpServletResponse);
		 
		}
	
	
	/**
	 * Descargar comprobante.
	 *
	 * @param request the request
	 * @param httpServletResponse the http servlet response
	 */
	@PostMapping("/AgregarClientesMS")
	public ModelAndView AgregarClientesMS(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		System.out.println("Saludos Mundo Cruel /BusquedaClientesMS");
		
		System.out.println("Verificar BusquedaClientesMS: " +  request.getParameter("BusquedaEmpresa"));
		System.out.println("Verificar BusquedaClientesMS: " +  request.getParameter("BusquedaRepLegal"));
		
		
		return service.AgregarClientesMS(request, httpServletResponse);
		 
		}
	
	
	
}
