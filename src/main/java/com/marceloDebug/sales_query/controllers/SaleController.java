package com.marceloDebug.sales_query.controllers;

import com.marceloDebug.sales_query.dtos.SaleDTO;
import com.marceloDebug.sales_query.dtos.SellerDTO;
import com.marceloDebug.sales_query.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping(value = "/report")
    public ResponseEntity<Page<SaleDTO>> getSales(
            @RequestParam(name = "minDate", defaultValue = "") String minDate,
            @RequestParam(name = "maxDate", defaultValue = "" ) String maxDate,
            @RequestParam(name = "name", defaultValue = "") String sellerName,
            Pageable pageable
    ){
        return ResponseEntity.ok(saleService.getSales(minDate, maxDate, sellerName, pageable));
    }

    @GetMapping(value = "/summary")
    public ResponseEntity<Page<SellerDTO>> getSummary(
            @RequestParam(name = "minDate", defaultValue = "") String minDate,
            @RequestParam(name = "maxDate", defaultValue = "" ) String maxDate,
            Pageable pageable
    ) {
        return ResponseEntity.ok(saleService.getSummary(minDate, maxDate, pageable));
    }
}
