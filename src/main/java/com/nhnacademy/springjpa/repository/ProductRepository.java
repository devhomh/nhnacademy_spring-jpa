package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.ProductDto;
import com.nhnacademy.springjpa.domain.ProductRequest;
import com.nhnacademy.springjpa.entity.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<ProductDto> getProductByCategory_CategoryName(String categoryName);
    @Query("select p from Product p  where p.unitCost > ?1")
    List<Product> getProductHavingPriceAtLeast(int unitCost);
    Page<ProductDto> findByModelNameContains(String modelName, Pageable pageable);

    Page<ProductDto> getAllBy(Pageable pageable);
}
