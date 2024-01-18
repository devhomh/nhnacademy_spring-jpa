package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.ProductDto;
import com.nhnacademy.springjpa.domain.ProductRequest;
import com.nhnacademy.springjpa.entity.Product;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product getProduct(int productId);
    Product registerProduct(ProductRequest registerRequest);
    void removeProduct(int productId);
    List<ProductDto> getProductByCategoryName(String categoryName);

    List<Product> getProductHavingPriceAtLeast(int unitCost);

    List<ProductDto> findByModelNameLike(String modelName);

    List<ProductDto> getAllBy(Pageable pageable);
}
