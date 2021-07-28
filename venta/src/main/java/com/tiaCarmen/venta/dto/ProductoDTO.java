package com.tiaCarmen.venta.dto;

import com.tiaCarmen.venta.model.Producto;

public class ProductoDTO {
    public Long id;
    public String nombre;
    public String codigoBarra;
    public int precioCosto;
    public int precioVenta;
    public int cantidad;

    public ProductoDTO(Producto producto, int catidadProducto) {
        id = producto.getId();
        nombre = producto.getNombre();
        codigoBarra = producto.getCodigoBarra();
        precioCosto = producto.getPrecioCosto();
        precioVenta = producto.getPrecioVenta();
        cantidad = catidadProducto;
    }
}