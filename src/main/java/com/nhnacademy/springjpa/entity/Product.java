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
@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "model_number")
    private String modelNumber;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "prouduct_image")
    private String productImage;

    @Column(name = "unitcost")
    private Integer unitCost;

    @Column(name = "description")
    private String description;
}
