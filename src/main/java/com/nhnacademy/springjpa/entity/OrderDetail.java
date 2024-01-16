package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "OrderDetails")
public class OrderDetail {
    @EmbeddedId
    private Pk pk;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unitcost")
    private Integer unitCost;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "order_id")
        private Integer orderId;

        @Column(name = "product_id")
        private Integer productId;
    }
}
