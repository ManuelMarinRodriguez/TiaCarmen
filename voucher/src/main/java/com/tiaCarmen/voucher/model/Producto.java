package com.tiaCarmen.voucher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * Clase representa a la tabla Producto
 * @author mmarinro
 *
 */
@Data
@Entity
@Table(name = "PRODUCTO")
public class Producto {
    @Id
    @Column(name = "ID_PRODUCTO")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CODIGOBARRA")
    private String codigoBarra;

    @Column(name = "PRECIOCOSTO")
    private int precioCosto;

    @Column(name = "PRECIOVENTA")
    private int precioVenta;

    @Column(name = "CANTIDAD")
    private int cantidad;    

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the codigoBarra
     */
    public String getCodigoBarra() {
        return codigoBarra;
    }

    /**
     * @param codigoBarra the codigoBarra to set
     */
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    /**
     * @return int return the precioCosto
     */
    public int getPrecioCosto() {
        return precioCosto;
    }

    /**
     * @param precioCosto the precioCosto to set
     */
    public void setPrecioCosto(int precioCosto) {
        this.precioCosto = precioCosto;
    }

    /**
     * @return int return the precioVenta
     */
    public int getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }


    /**
     * @return int return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
