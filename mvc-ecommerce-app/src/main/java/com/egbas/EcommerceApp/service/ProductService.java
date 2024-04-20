package com.egbas.EcommerceApp.service;

import com.egbas.EcommerceApp.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProducts(Product product);

    List<Product> getAllProducts();
}
