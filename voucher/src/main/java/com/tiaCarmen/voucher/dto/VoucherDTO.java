package com.tiaCarmen.voucher.dto;

import java.util.ArrayList;


/**
 * 
 * @author mmarinro
 *
 */
public class VoucherDTO {
    private Long id;
    private ArrayList<ProductoDTO> productos;

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
     * @return ArrayList<ProductoDTO> return the productos
     */
    public ArrayList<ProductoDTO> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(ArrayList<ProductoDTO> productos) {
        this.productos = productos;
    }

}
