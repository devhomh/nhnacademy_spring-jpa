package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.ShoppingCartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, ShoppingCartProduct.Pk> {
}
