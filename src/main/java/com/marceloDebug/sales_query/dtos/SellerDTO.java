package com.marceloDebug.sales_query.dtos;

import com.marceloDebug.sales_query.entities.Sale;
import com.marceloDebug.sales_query.entities.Seller;

public class SellerDTO {
    private String sellerName;
    private Double total;

    public SellerDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }

    public SellerDTO(Seller seller){
        sellerName = seller.getName();
    }

    public SellerDTO(){}

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
