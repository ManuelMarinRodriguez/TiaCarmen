package com.tiaCarmen.venta.dto;

import com.tiaCarmen.venta.model.Producto;

/**
 * Clase para poder guardar los datos
 * que se utlizizaran para los productos
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

    public ProductoDTO(Producto producto, double catidadProducto) {
        id = producto.getId();
        nombre = producto.getNombre();
        codigoBarra = producto.getCodigoBarra();
        precioCosto = producto.getPrecioCosto();
        precioVenta = producto.getPrecioVenta();
        cantidad = catidadProducto;
    }
}