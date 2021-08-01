package com.tiaCarmen.voucher.dto;

import java.util.ArrayList;

import lombok.Data;

/**
 * 
 * @author mmarinro
 *
 */
@Data
public class NuevoVoucherDTO {
    public Long idVoucher;
    public ArrayList<ProductoDTO> productos;
}
