package com.marceloDebug.sales_query.dtos;

import com.marceloDebug.sales_query.entities.Sale;

import java.time.LocalDate;

public class SaleDTO {
    private Long id;
    private LocalDate date;
    private Double amount;
    private String sellerName;

    public SaleDTO(Long id, LocalDate date, Double amount, String sellerName) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.sellerName = sellerName;
    }

    public SaleDTO(Sale sale){
        id = sale.getId();
        date = sale.getDate();
        amount = sale.getAmount();
        sellerName = sale.getSeller().getName();
    }

    public SaleDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
