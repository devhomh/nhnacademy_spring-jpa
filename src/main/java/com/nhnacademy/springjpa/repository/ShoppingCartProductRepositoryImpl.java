package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.QShoppingCartProduct;
import com.nhnacademy.springjpa.entity.ShoppingCart;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class ShoppingCartProductRepositoryImpl extends QuerydslRepositorySupport implements
        ShoppingCartRepositoryProductCustom {

    public ShoppingCartProductRepositoryImpl() {
        super(ShoppingCart.class);
    }

    @Override
    public long updateQuantity(int cartId, int productId, int quantity) {
        QShoppingCartProduct shoppingCartProduct = QShoppingCartProduct.shoppingCartProduct;

        return update(shoppingCartProduct)
                .set(shoppingCartProduct.quantity, quantity)
                .where(shoppingCartProduct.pk.cartId.eq(cartId)
                        .and(shoppingCartProduct.pk.productId.eq(productId)))
                .execute();


    }
}


