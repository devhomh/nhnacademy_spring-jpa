package com.nhnacademy.springjpa.repository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ShoppingCartRepositoryProductCustom {
    long updateQuantity(int cartId, int productId, int quantity);
}
