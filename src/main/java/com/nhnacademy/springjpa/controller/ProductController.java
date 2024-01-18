package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{productId}")
    public String viewProduct(@PathVariable("productId") int productId,
                              ModelMap modelMap){
        return "product";
    }
}
