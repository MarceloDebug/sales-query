package com.marceloDebug.sales_query.repositories;

import com.marceloDebug.sales_query.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
