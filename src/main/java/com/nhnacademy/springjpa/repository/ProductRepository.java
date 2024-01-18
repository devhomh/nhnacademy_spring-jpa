package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.ProductDto;
import com.nhnacademy.springjpa.entity.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<ProductDto> findByModelNameLike(String modelName);
    @Query("select p from Product p  where p.unitCost > ?1")
    List<Product> getProductHavingPriceAtLeast(int unitCost);

    Page<ProductDto> getAllBy(Pageable pageable);

    @Modifying
    @Query("update Product p set p.quantity = :quantity where p.productId = :productId")
    int updateQuantity(@Param("productId") int productId, @Param("quantity") int quantity);
    @Modifying
    @Query("update Product p set p.unitCost = :unitCost where p.productId = :productId")
    int updateUnitCost(@Param("productId") int productId, @Param("unitCost") int unitCost);
}
