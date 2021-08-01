package com.tiaCarmen.clientes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.tiaCarmen.clientes.dto.ClientesDTO;
import com.tiaCarmen.clientes.dto.EmpresaClienteDto;
import com.tiaCarmen.clientes.dto.RepresentanteLegalDTO;
import com.tiaCarmen.clientes.repository.EmpresaDao;
import com.tiaCarmen.clientes.repository.RepresentanteLegalDao;
import com.tiaCarmen.clientes.util.Constantes;
import com.tiaCarmen.clientes.model.Empresa;
import com.tiaCarmen.clientes.model.RepresentanteLegal;
/**
 * 
 * @author mmarinro
 *
 */
@Service
public class ClientesService {
	
	@Autowired
	EmpresaDao empresaDao;
	
	@Autowired
	RepresentanteLegalDao repLegalDao;
	/**
	 * Busca si los datos de la empresa y el representante legal 
	 * existen en la BD
	 * @param json
	 * @return
	 */
	public ClientesDTO validaClientes(String json) {
		ClientesDTO rsp = new ClientesDTO();
		Gson gson = new Gson();
		try {
			json = json.replace("\\", "");
			json = json.replace("{\"json\":[\"", "");
			json = json.replace("]}", "");
			
			System.out.println("Verificar Json Final : " + json);
			rsp = gson.fromJson(json, ClientesDTO.class);
			List<Empresa> entityCliEmp = new ArrayList<Empresa>();
			List<RepresentanteLegal> entityCliRepLegal = new ArrayList<RepresentanteLegal>();
			
			entityCliEmp = empresaDao.findByCliRut(rsp.getRutEmpresa());
			
			entityCliRepLegal = repLegalDao.findByRepLegalRut(rsp.getRutRepresentanteLegal());
			
			if (entityCliEmp.size() > 0 ) {
				rsp.setRutEmpresa(Constantes.existe_empresa);
			}else {
				
				rsp.setRutEmpresa(Constantes.no_existe_empresa);
			}
			
			if (entityCliRepLegal.size() > 0 ) {
				rsp.setRutRepresentanteLegal(Constantes.existe_rep_legal);
			}else {
				
				rsp.setRutRepresentanteLegal(Constantes.no_existe_rep_legal);
			}
			

		} catch (Exception e) {
			
		}
		return rsp;
	}

	/**
	 * Metodo para agregar a la empresa,
	 * envia respuesta de la inserción en campo Respuesta
	 * @param json
	 * @return
	 */
	public EmpresaClienteDto agregarEmpresa(String json) {

		Empresa nuevaEmpresa = new Empresa();
		EmpresaClienteDto rsp = new EmpresaClienteDto();
		Gson gson = new Gson();
		
		try {
			json = json.replace("\\", "");
			json = json.replace("{\"json\":[\"", "");
			json = json.replace("]}", "");
			
			System.out.println("Verificar Json filtrado Emp : " + json);
			rsp = gson.fromJson(json, EmpresaClienteDto.class);
			rsp.setRespuesta(Constantes.exito_guardar_empresa);
			nuevaEmpresa.setRutEmpresa(rsp.getRutEmpresa());
			nuevaEmpresa.setNombreEmpresa(rsp.getNombreEmpresa());
			nuevaEmpresa.setEmailEmpresa(rsp.getEmailEmpresa());
			nuevaEmpresa.setTelefonoEmpresa(rsp.getTelefonoEmpresa());
			empresaDao.save(nuevaEmpresa);
			
			
			
			
		} catch (Exception e) {
			
			rsp.setRespuesta(Constantes.error_guardar_empresa);
		}
		return rsp;
		
	}
	/**
	 * Metodo para agregar al representante legal
	 * Envio de exito o error en campo respuesta
	 * @param json
	 * @return
	 */
	public RepresentanteLegalDTO agregarRepLegal(String json) {

		RepresentanteLegal nuevaRepLegal = new RepresentanteLegal();
		RepresentanteLegalDTO rsp = new RepresentanteLegalDTO();
		Gson gson = new Gson();
		String Guardado = Constantes.exito_guardar_rep_legal;
		try {
			json = json.replace("\\", "");
			json = json.replace("{\"json\":[\"", "");
			json = json.replace("]}", "");
			
			System.out.println("Verificar Json Filtrado RL : " + json);
			rsp = gson.fromJson(json, RepresentanteLegalDTO.class);
			
			nuevaRepLegal.setRutEmpresa(rsp.getRutEmpresa());
			nuevaRepLegal.setRutRepresentanteLegal(rsp.getRutRepresentanteLegal());
			nuevaRepLegal.setEmailRepresentanteLegal(rsp.getEmailRepresentanteLegal());
			nuevaRepLegal.setNombreRepresentanteLegal(rsp.getNombreRepresentanteLegal());
			nuevaRepLegal.setTelefonoRepresentanteLegal(rsp.getTelefonoRepresentanteLegal());
			
			repLegalDao.save(nuevaRepLegal);
			rsp.setRespuesta(Guardado);
			
			
			
		} catch (Exception e) {
			System.out.println("Error al guardar los datos del representante Legal");
			Guardado = Constantes.error_guardar_rep_legal;
			rsp.setRespuesta(Guardado);
		}
		return rsp;
		
	}

}
