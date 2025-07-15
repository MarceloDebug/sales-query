package com.marceloDebug.sales_query.repositories;

import com.marceloDebug.sales_query.dtos.SaleDTO;
import com.marceloDebug.sales_query.dtos.SellerDTO;
import com.marceloDebug.sales_query.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT new com.marceloDebug.sales_query.dtos.SaleDTO(sale.id, sale.date, sale.amount, sale.seller.name) FROM Sale sale " +
            "WHERE sale.date BETWEEN :minDate and :maxDate " +
            "AND UPPER(sale.seller.name) LIKE UPPER(CONCAT('%',:name,'%' ))",
            countQuery = "SELECT COUNT(sale) FROM Sale sale " +
                    "WHERE sale.date BETWEEN :minDate and :maxDate " +
                    "AND UPPER(sale.seller.name) LIKE UPPER(CONCAT('%',:name,'%' ))")
    Page<SaleDTO> searchSales(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable);

    @Query(value = "SELECT new com.marceloDebug.sales_query.dtos.SellerDTO(sale.seller.name, SUM(sale.amount)) " +
            "FROM Sale sale " +
            "where sale.date BETWEEN :min and :max GROUP BY sale.seller.name",
            countQuery = "SELECT COUNT(DISTINCT sale.seller.name) FROM Sale sale " +
                    "where sale.date BETWEEN :min and :max")
    Page<SellerDTO> searchSummary(LocalDate min, LocalDate max, Pageable pageable);
}
