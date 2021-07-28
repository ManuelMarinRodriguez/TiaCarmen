package com.tiaCarmen.FrontEndCarniceria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

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
	
	
}
