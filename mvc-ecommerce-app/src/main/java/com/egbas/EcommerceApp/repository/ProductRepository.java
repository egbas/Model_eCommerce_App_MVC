package com.egbas.EcommerceApp.repository;

import com.egbas.EcommerceApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
