package com.tiaCarmen.voucher.controller;

import com.tiaCarmen.voucher.dto.VoucherDTO;
import com.tiaCarmen.voucher.service.VoucherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class VoucherController {

    @Autowired
    VoucherService service;

    @GetMapping("/consultavoucher/{numero}")
    public VoucherDTO consultaVoucher(@PathVariable Long numero) {
        return service.getVoucher(numero);
    }

	@PostMapping("/agregarvoucher")
	public String agregarVoucher(@RequestBody String json) {

		return service.agregarVoucher(json);
	}    
}