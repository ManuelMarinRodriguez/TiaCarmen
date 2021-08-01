package com.tiaCarmen.voucher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * Clase representa a la tabla Voucher
 * @author mmarinro
 *
 */
@Data
@Entity
@Table(name = "VOUCHER")
public class Voucher {
    @Id
    @Column(name = "ID_VOUCHER")
    private Long idVoucher;

    public Voucher(Long idVoucher) {
        this.idVoucher = idVoucher;
    }

    public Voucher() {

    }

    /**
     * @return Long return the idVoucher
     */
    public Long getIdVoucher() {
        return idVoucher;
    }

    /**
     * @param idVoucher the idVoucher to set
     */
    public void setIdVoucher(Long idVoucher) {
        this.idVoucher = idVoucher;
    }

}
