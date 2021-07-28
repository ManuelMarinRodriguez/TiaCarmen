package com.tiaCarmen.venta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.tiaCarmen.venta.Util.Constantes;
import com.tiaCarmen.venta.dto.ProductoDTO;
import com.tiaCarmen.venta.dto.VentaDTO;
import com.tiaCarmen.venta.model.Producto;
import com.tiaCarmen.venta.model.Venta;
import com.tiaCarmen.venta.repository.DetalleVoucherDao;
import com.tiaCarmen.venta.repository.ProductoDao;
import com.tiaCarmen.venta.repository.VentaDao;

/**
 * 
 * @author msagredo
 *
 */
@Service
public class VentaService {

    @Autowired
    VentaDao ventaDao;

    @Autowired
    ProductoDao productoDao;
    
    @Autowired
    DetalleVoucherDao detalleVoucherDao;
    
    

    public VentaDTO getVenta(Long numero) {

        var venta = new VentaDTO();
    
        try {

            var entityVenta = ventaDao.findByNumero(numero);
         
            if (entityVenta != null) {
                venta = new VentaDTO(entityVenta);
                var entitiesProductos = productoDao.findByVoucherId(entityVenta.getVoucherId());

                for (Producto entityProducto : entitiesProductos) {
                	String nombre = entityProducto.getNombre();
                	int Cantidad = cantidadVentaProducto(numero, nombre);
                	
                    var producto = new ProductoDTO(entityProducto, Cantidad);
                	venta.setProducto(producto);
	
                    
                }
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return venta;
    }

    private int cantidadVentaProducto(Long numero, String nombre) {
    	
    	System.out.println("numero : " + numero);
    	System.out.println("nombre : " + nombre);
    	var detalleVou = detalleVoucherDao.findByDetalleVoucherId(numero, nombre);
    	int Paso = detalleVou.get(0).getCantidad();
    	
		return Paso;
	}

	public String agregarVenta(String json) {

        VentaDTO rsp = new VentaDTO();
        Gson gson = new Gson();
        String Guardado = Constantes.exito_guardar_venta;
        try {
            json = json.replace("\\", "");
            json = json.replace("{\"json\":[\"", "");
            json = json.replace("]}", "");

            System.out.println("Verificar Json Final : " + json);
            rsp = gson.fromJson(json, VentaDTO.class);

            var numero = ventaDao.getNumero();

            Venta nuevaVenta = new Venta(numero, rsp.monto, rsp.tipoVenta, rsp.voucherId);
            ventaDao.save(nuevaVenta);

        } catch (Exception e) {
            System.out.println(e);
            Guardado = Constantes.error_guardar_venta;
        }
        return Guardado;
    }
}
