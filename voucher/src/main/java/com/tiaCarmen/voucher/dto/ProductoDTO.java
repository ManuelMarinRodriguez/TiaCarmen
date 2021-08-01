package com.tiaCarmen.voucher.dto;

import com.tiaCarmen.voucher.model.Producto;

/**
 * 
 * @author mmarinro
 *
 */
public class ProductoDTO {
    public Long id;
    public String nombre;
    public String codigoBarra;
    public int precioCosto;
    public int precioVenta;
    public double cantidad;

    public ProductoDTO(Producto producto) {
        id = producto.getId();
        nombre = producto.getNombre();
        codigoBarra = producto.getCodigoBarra();
        precioCosto = producto.getPrecioCosto();
        precioVenta = producto.getPrecioVenta();
        cantidad = producto.getCantidad();
    }
}
