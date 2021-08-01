package com.tiaCarmen.clientes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Clase que funciona para conectar
 * a tabla REPRESENTANTELEGAL
 * @author mmarinro
 *
 */
@Data
@Entity
@Table(name="REPRESENTANTELEGAL")
public class RepresentanteLegal {
	
	
	@Id
	@Column(name="RUT_EMPRESA")
	private String rutEmpresa;
	
	@Column(name="RUT_REPRESENTANTE_LEGAL")
	private String rutRepresentanteLegal;
	
	@Column(name="NOMBRE_REPRESENTANTE_LEGAL")
	private String nombreRepresentanteLegal;
	
	@Column(name="TELEFONO_REPRESENTANTE_LEGAL")
	private String telefonoRepresentanteLegal;
	
	@Column(name="EMAIL_REPRESENTANTE_LEGAL")
	private String emailRepresentanteLegal;

}
