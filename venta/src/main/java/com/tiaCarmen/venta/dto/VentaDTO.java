package com.tiaCarmen.venta.dto;

import java.util.ArrayList;
import java.util.Date;

import com.tiaCarmen.venta.model.Venta;

import lombok.Data;

/**
 * Clase que guardara los datos
 * para poder realizar una venta
 * 
 * @author mmarinro
 *
 */
@Data
public class VentaDTO {

    public Long numero;
    public Integer monto;
    public Date fecha;
    public String tipoVenta;
    public Long voucherId;
    public ArrayList<ProductoDTO> productos;

    public VentaDTO() {
        productos = new ArrayList<ProductoDTO>();
    }

    public VentaDTO(Venta venta) {
        numero = venta.getNumero();
        monto = venta.getMonto();
        fecha = venta.getFecha();
        tipoVenta = venta.getTipo();
        voucherId = venta.getVoucherId();

        productos = new ArrayList<ProductoDTO>();
    }

    public void setProducto(ProductoDTO producto) {
        productos.add(producto);
    }
}