package com.tiaCarmen.FrontEndCarniceria.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.log.SysoCounter;
import com.tiaCarmen.FrontEndCarniceria.dto.ClientesDTO;
import com.tiaCarmen.FrontEndCarniceria.dto.EmpresaClienteDto;
import com.tiaCarmen.FrontEndCarniceria.dto.RepresentanteLegalDTO;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


@Service
public class FrontService {

	public ModelAndView busquedaProducto(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		mav = new ModelAndView("VentaFinal");
		return mav;
	}

	public ModelAndView BusquedaClientes(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		mav = new ModelAndView("BuscarClientes");
		return mav;
	}
	
	
	
	public void pagarBoleta(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		// TODO Auto-generated method stub
		
		System.out.println("Verificar Voucher: " +  request.getParameter("BusquedaProducto"));
		
	}

	public ModelAndView BusquedaClientesMS(HttpServletRequest request, HttpServletResponse httpServletResponse) {


		final String EnpointBClientes = "http://localhost:8024/ConsultaClientes";
		RestTemplate restTemplate = new RestTemplate();
    	MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    	ClientesDTO rsp = new ClientesDTO();
    	String RutEmpresaMS = request.getParameter("BusquedaEmpresa");
    	RutEmpresaMS= RutEmpresaMS.replace(".", "");
    	RutEmpresaMS= RutEmpresaMS.replace("-", "");
    	
    	String RutRepLegalMS = request.getParameter("BusquedaRepLegal");
    	RutRepLegalMS= RutRepLegalMS.replace(".", "");
    	RutRepLegalMS= RutRepLegalMS.replace("-", "");
    	
    	map.add("rutEmpresa",RutEmpresaMS);
		map.add("rutRepresentanteLegal",RutRepLegalMS);
		HttpEntity<MultiValueMap<String, String>> requestMS = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ClientesDTO responseMS = restTemplate.postForObject( EnpointBClientes, requestMS , ClientesDTO.class );
		String RepLegal = responseMS.getRutRepresentanteLegal();
		String Empresa = responseMS.getRutEmpresa();
		
		System.out.println("RepLegal : " + RepLegal);
		System.out.println("Empresa : " + Empresa);
		
		
		ModelAndView mav = null;
		
		if (RepLegal.equals("NO") && Empresa.equals("NO")) {
			rsp.setRutEmpresa(RutEmpresaMS);
			rsp.setRutRepresentanteLegal(RutRepLegalMS);
			mav = new ModelAndView("AgregarClientes");
			mav.addObject("obj", rsp);
			
		}else {
		
			mav = new ModelAndView("VoucherFactura");
		}
		
		
		return mav;
	}

	public ModelAndView AgregarClientesMS(HttpServletRequest request, HttpServletResponse httpServletResponse) {

		
		final String EnpointAgregarRepLegal = "http://localhost:8024/AgregarRepLegal";
		final String EnpointAgregarEmpresa = "http://localhost:8024/AgregarEmpresa";
		AgregaEmpresa(request, EnpointAgregarEmpresa);
		AgregarRepLegal(request, EnpointAgregarRepLegal);
		
		
		

		ModelAndView mav = null;
		mav = new ModelAndView("VoucherFactura");
		
		return mav;
		
	}

	private void AgregaEmpresa(HttpServletRequest request, String enpointAgregarEmpresa) {

			
		RestTemplate restTemplate = new RestTemplate();
    	MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    	map.add("rutEmpresa", request.getParameter("RutEmpresa"));
		map.add("nombreEmpresa", request.getParameter("NombreEmpresa"));
		map.add("telefonoEmpresa", request.getParameter("TelefonoEmpresa"));
		map.add("emailEmpresa", request.getParameter("EmailEmpresa"));
		
		HttpEntity<MultiValueMap<String, String>> requestMS = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		EmpresaClienteDto responseMS =restTemplate.postForObject( enpointAgregarEmpresa, requestMS , EmpresaClienteDto.class );
		System.out.println(responseMS.getRespuesta());
		
	}

	private void AgregarRepLegal(HttpServletRequest request, String enpointAgregarRepLegal) {


		
		RestTemplate restTemplate = new RestTemplate();
    	MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    	map.add("rutEmpresa", request.getParameter("RutEmpresa"));
    	map.add("rutRepresentanteLegal", request.getParameter("RutRepLegal"));
		map.add("nombreRepresentanteLegal", request.getParameter("NombreRepLegal"));
		map.add("telefonoRepresentanteLegal", request.getParameter("TelefonoRepLegal"));
		map.add("emailRepresentanteLegal", request.getParameter("EmailRepLegal"));
		
		HttpEntity<MultiValueMap<String, String>> requestMS = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		restTemplate.postForObject( enpointAgregarRepLegal, requestMS , RepresentanteLegalDTO.class );
		
	}

}
