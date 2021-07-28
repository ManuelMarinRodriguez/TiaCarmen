package com.tiaCarmen.venta.dto;

import java.util.ArrayList;
import java.util.Date;

import com.tiaCarmen.venta.model.Venta;

import lombok.Data;

@Data
public class VentaDTO {

    public Long numero;
    public Integer monto;
    public Date fecha;
    public Boolean tipoVenta;
    public Long voucherId;
    public ArrayList<ProductoDTO> productos;

    public VentaDTO() {
        productos = new ArrayList<ProductoDTO>();
    }

    public VentaDTO(Venta venta) {
        numero = venta.getNumero();
        monto = venta.getMonto();
        fecha = venta.getFecha();
        tipoVenta = venta.isTipo();
        voucherId = venta.getVoucherId();

        productos = new ArrayList<ProductoDTO>();
    }

    public void setProducto(ProductoDTO producto) {
        productos.add(producto);
    }
}