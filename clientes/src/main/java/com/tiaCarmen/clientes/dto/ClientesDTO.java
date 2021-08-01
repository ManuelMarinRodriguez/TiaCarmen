package com.tiaCarmen.clientes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Clase que almancena los datos de entrada 
 * del Json y funciona como respuesta
 * @author mmarinro
 *
 */
@Data
public class ClientesDTO {


	/**  String rutEmpresa *. */
	@JsonProperty("rutEmpresa")
	private String rutEmpresa;
	
	/**  String rutRepresentanteLegal *. */
	@JsonProperty("rutRepresentanteLegal")
	private String rutRepresentanteLegal;
	
}
