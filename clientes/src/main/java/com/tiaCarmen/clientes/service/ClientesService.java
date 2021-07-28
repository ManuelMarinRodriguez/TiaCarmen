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
	
	public ClientesDTO validaClientes(ClientesDTO vo) {
		ClientesDTO rsp = new ClientesDTO();
		Gson gson = new Gson();
		try {
//			json = json.replace("\\", "");
//			json = json.replace("{\"json\":[\"", "");
//			json = json.replace("]}", "");
//			
//			System.out.println("Verificar Json Final : " + json);
//			rsp = gson.fromJson(json, ClientesDTO.class);
			List<Empresa> entityCliEmp = new ArrayList<Empresa>();
			List<RepresentanteLegal> entityCliRepLegal = new ArrayList<RepresentanteLegal>();
			
			entityCliEmp = empresaDao.findByCliRut(vo.getRutEmpresa());
			
			entityCliRepLegal = repLegalDao.findByRepLegalRut(vo.getRutRepresentanteLegal());
			
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
			
			System.out.println("MMR " + rsp);
			
			//LLAMADA A LA BD 
			
		} catch (Exception e) {
			
		}
		return rsp;
	}

	public EmpresaClienteDto agregarEmpresa(EmpresaClienteDto vo) {

		Empresa nuevaEmpresa = new Empresa();
//		EmpresaClienteDto rsp = new EmpresaClienteDto();
//		Gson gson = new Gson();
		vo.setRespuesta(Constantes.exito_guardar_empresa);
		try {
//			json = json.replace("\\", "");
//			json = json.replace("{\"json\":[\"", "");
//			json = json.replace("]}", "");
//			
//			System.out.println("Verificar Json Final : " + json);
//			rsp = gson.fromJson(json, EmpresaClienteDto.class);
//			
			nuevaEmpresa.setRutEmpresa(vo.getRutEmpresa());
			nuevaEmpresa.setNombreEmpresa(vo.getNombreEmpresa());
			nuevaEmpresa.setEmailEmpresa(vo.getEmailEmpresa());
			nuevaEmpresa.setTelefonoEmpresa(vo.getTelefonoEmpresa());
			empresaDao.save(nuevaEmpresa);
			
			
			
			
		} catch (Exception e) {
			
			vo.setRespuesta(Constantes.error_guardar_empresa);
		}
		return vo;
		
	}

	public RepresentanteLegalDTO agregarRepLegal(RepresentanteLegalDTO vo) {

		RepresentanteLegal nuevaRepLegal = new RepresentanteLegal();
//		RepresentanteLegalDTO rsp = new RepresentanteLegalDTO();
//		Gson gson = new Gson();
		String Guardado = Constantes.exito_guardar_rep_legal;
		try {
//			json = json.replace("\\", "");
//			json = json.replace("{\"json\":[\"", "");
//			json = json.replace("]}", "");
//			
//			System.out.println("Verificar Json Final : " + json);
//			rsp = gson.fromJson(json, RepresentanteLegalDTO.class);
			
			nuevaRepLegal.setRutEmpresa(vo.getRutEmpresa());
			nuevaRepLegal.setRutRepresentanteLegal(vo.getRutRepresentanteLegal());
			nuevaRepLegal.setEmailRepresentanteLegal(vo.getEmailRepresentanteLegal());
			nuevaRepLegal.setNombreRepresentanteLegal(vo.getNombreRepresentanteLegal());
			nuevaRepLegal.setTelefonoRepresentanteLegal(vo.getTelefonoRepresentanteLegal());
			
			repLegalDao.save(nuevaRepLegal);
			
			
		} catch (Exception e) {
			
			Guardado = Constantes.error_guardar_rep_legal;
		}
		return vo;
		
	}

}
