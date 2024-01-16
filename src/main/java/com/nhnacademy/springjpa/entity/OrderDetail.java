package com.nhnacademy.springjpa.entity;

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
@Table(name = "OrderDetails")
public class OrderDetail {
    @Id
    @Column(name = "OrderID")
    private Integer orderId;

    @Column(name = "ProductID")
    private Integer productId;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "UnitCost")
    private Integer unitCost;
}
