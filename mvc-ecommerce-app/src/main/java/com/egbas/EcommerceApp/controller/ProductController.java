package com.egbas.EcommerceApp.controller;

import com.egbas.EcommerceApp.model.Product;
import com.egbas.EcommerceApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/new")
    public String addProductsForm(Model model){
        Product product = new Product();

        model.addAttribute("product", product);
        return "create_product";
    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProducts(product);

        return "redirect:/products";

    }

    @GetMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
}
