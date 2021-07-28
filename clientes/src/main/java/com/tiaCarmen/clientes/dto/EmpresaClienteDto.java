package com.tiaCarmen.clientes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmpresaClienteDto {

	
	/**the RutEmpresa**/
	@JsonProperty("rutEmpresa")
	private String rutEmpresa;
	
	/**the NombreEmpresa*/
	@JsonProperty("nombreEmpresa")
	private String nombreEmpresa;
	
	/**the Telefono*/
	@JsonProperty("telefonoEmpresa")
	private String telefonoEmpresa;
	
	/**the EmailEmpresa*/
	@JsonProperty("emailEmpresa")
	private String emailEmpresa;
	
	/**the respuesta*/
	@JsonProperty("respuesta")
	private String respuesta;

	public void setRespuesta(String exito_guardar_empresa) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
