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
    @Column(name = "RecordID")
    private Integer recordId;

    @Column(name = "CartID")
    private String cartId;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "ProductID")
    private Integer productId;

    @Column(name = "DateCreated")
    private LocalDateTime dateCreated;
}
