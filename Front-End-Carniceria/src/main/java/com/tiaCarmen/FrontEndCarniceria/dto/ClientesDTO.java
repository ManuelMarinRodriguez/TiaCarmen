package com.tiaCarmen.FrontEndCarniceria.dto;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
@EntityScan
public class ClientesDTO {

	
	/**  String rutEmpresa *. */
	@JsonProperty("rutEmpresa")
	private String rutEmpresa;
	
	/**  String rutRepresentanteLegal *. */
	@JsonProperty("rutRepresentanteLegal")
	private String rutRepresentanteLegal;
	
	
}
