package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.ProductDto;
import com.nhnacademy.springjpa.domain.ProductRequest;
import com.nhnacademy.springjpa.entity.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product getProduct(int productId);
    Product registerProduct(ProductRequest registerRequest);
    void removeProduct(int productId);
    Page<ProductDto> getProductByCategoryName(String categoryName, Pageable pageable);

    List<Product> getProductHavingPriceAtLeast(int unitCost);

    Page<ProductDto> findByModelNameContains(String modelName, Pageable pageable);

    Page<ProductDto> getAllBy(Pageable pageable);
}
