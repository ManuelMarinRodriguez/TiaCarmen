package com.tiaCarmen.voucher.service;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.tiaCarmen.voucher.dto.NuevoVoucherDTO;
import com.tiaCarmen.voucher.dto.ProductoDTO;
import com.tiaCarmen.voucher.dto.VoucherDTO;
import com.tiaCarmen.voucher.model.DetalleVoucher;
import com.tiaCarmen.voucher.model.Producto;
import com.tiaCarmen.voucher.model.Voucher;
import com.tiaCarmen.voucher.repository.DetalleVoucherDao;
import com.tiaCarmen.voucher.repository.ProductoDao;
import com.tiaCarmen.voucher.repository.VoucherDao;
import com.tiaCarmen.voucher.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author mmarinro
 *
 */
@Service
public class VoucherService {

    @Autowired
    DetalleVoucherDao repositoryDetalleVoucher;

    @Autowired
    VoucherDao repositoryVoucher;

    @Autowired
    ProductoDao repositoryProducto;

    /**
     * Retorna el voucher
     * @param id
     * @return
     */
    public VoucherDTO getVoucher(Long id) {

        var voucher = new VoucherDTO();

        try {
            var entityVoucher = repositoryVoucher.findByNumero(id);

            if (entityVoucher != null) {
                voucher.setId(entityVoucher.getIdVoucher());

                var productos = getProductos(id);
                voucher.setProductos(productos);
            }
        } catch (Exception e) {
        	System.out.println("Error al traer el voucher : " + e);
        }

        return voucher;
    }
    /**
     * Trae los productos
     * @param voucherId
     * @return
     */
    private ArrayList<ProductoDTO> getProductos(Long voucherId) {
        var productos = new ArrayList<ProductoDTO>();

        try {
            var entitiesProductos = repositoryProducto.findByVoucherId(voucherId);

            for (Producto entityProducto : entitiesProductos) {
                var producto = new ProductoDTO(entityProducto);
                productos.add(producto);
            }
        } catch (Exception e) {
        	System.out.println("Error al traer productos : " + e);
        }

        return productos;
    }
    
    
    /**
     * Agrega un nuevo voucher
     * @param json
     * @return
     */
    public String agregarVoucher(String json) {

        Gson gson = new Gson();
        String guardado = Constantes.exito_guardar_voucher;

        try {
            json = json.replace("\\", "");
            json = json.replace("{\"json\":[\"", "");
            json = json.replace("]}", "");

            var voucher = gson.fromJson(json, NuevoVoucherDTO.class);

            var idVoucher = repositoryVoucher.getCorrelativo();

            var nuevoVoucher = new Voucher(idVoucher);
            repositoryVoucher.save(nuevoVoucher);

            for (ProductoDTO producto : voucher.productos) {
                var nuevoDetalleVoucher = new DetalleVoucher(idVoucher, producto.id, producto.cantidad);
                repositoryDetalleVoucher.save(nuevoDetalleVoucher);
            }

        } catch (Exception e) {
            System.out.println(e);
            guardado = Constantes.error_guardar_venta;
        }
        return guardado;
    }
}
