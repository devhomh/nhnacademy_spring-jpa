package com.nhnacademy.springjpa.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {
    @Id
    @Column(name = "record_id")
    private Integer recordId;

    @Column(name = "cart_id")
    private String cartId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "created_at")
    private LocalDateTime dateCreated;
}
