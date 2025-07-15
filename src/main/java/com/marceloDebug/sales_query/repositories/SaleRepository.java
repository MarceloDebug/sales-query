package com.marceloDebug.sales_query.repositories;

import com.marceloDebug.sales_query.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
