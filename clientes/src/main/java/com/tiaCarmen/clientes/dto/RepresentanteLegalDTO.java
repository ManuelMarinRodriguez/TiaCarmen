package com.tiaCarmen.clientes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Clase que funciona para poder guardar
 * a cliente Representante legal
 * @author mmarinro
 *
 */
@Data
public class RepresentanteLegalDTO {

	
	/**the RutEmpresa**/
	@JsonProperty("rutEmpresa")
	private String rutEmpresa;
	
	/**the RutRepresentanteLegal**/
	@JsonProperty("rutRepresentanteLegal")
	private String rutRepresentanteLegal;
	
	/**the NombreRepresentanteLegal*/
	@JsonProperty("nombreRepresentanteLegal")
	private String nombreRepresentanteLegal;
	
	/**the TelefonoRepresentanteLegal*/
	@JsonProperty("telefonoRepresentanteLegal")
	private String telefonoRepresentanteLegal;
	
	/**the EmailRepresentanteLegal*/
	@JsonProperty("emailRepresentanteLegal")
	private String emailRepresentanteLegal;
	
	/**the EmailRepresentanteLegal*/
	@JsonProperty("respuesta")
	private String respuesta;
	
	
	
}
