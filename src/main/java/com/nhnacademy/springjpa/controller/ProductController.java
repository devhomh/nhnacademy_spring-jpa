package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.entity.Product;
import com.nhnacademy.springjpa.repository.ProductRepository;
import com.nhnacademy.springjpa.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public String viewProduct(@PathVariable("productId") int productId,
                              ModelMap modelMap){
        Product product = productService.getProduct(productId);

        modelMap.addAttribute("product", product);
        return "product";
    }
}
