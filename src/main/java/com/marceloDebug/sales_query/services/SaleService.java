package com.marceloDebug.sales_query.services;

import com.marceloDebug.sales_query.dtos.SaleDTO;
import com.marceloDebug.sales_query.dtos.SellerDTO;
import com.marceloDebug.sales_query.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Transactional
    public Page<SaleDTO> getSales(String minDate, String maxDate, String name, Pageable pageable){
        LocalDate max = (maxDate.isEmpty())? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()) :LocalDate.parse(maxDate);
        LocalDate min = (maxDate.isEmpty())? max.minusYears(1L) :LocalDate.parse(minDate);

        return saleRepository.searchSales(min, max, name, pageable);
    }

    @Transactional
    public Page<SellerDTO> getSummary(String minDate, String maxDate, Pageable pageable){
        LocalDate max = (maxDate.isEmpty())? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()) :LocalDate.parse(maxDate);
        LocalDate min = (maxDate.isEmpty())? max.minusYears(1L) :LocalDate.parse(minDate);

        return saleRepository.searchSummary(min, max, pageable);
    }

}
