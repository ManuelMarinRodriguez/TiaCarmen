package com.tiaCarmen.clientes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="EMPRESA")
public class Empresa {
	
	
	@Id
	@Column(name="RUT")
	private String rutEmpresa;
	
	@Column(name="NOMBRE_EMPRESA")
	private String nombreEmpresa;
	
	@Column(name="TELEFONO_EMPRESA")
	private String telefonoEmpresa;
	
	@Column(name="EMAIL_EMPRESA")
	private String emailEmpresa;

}
