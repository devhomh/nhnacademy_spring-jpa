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
    @Column(name = "ProductID")
    private Integer productId;

    @Column(name = "CategoryID")
    private Integer categoryId;

    @Column(name = "ModelNumber")
    private String modelNumber;

    @Column(name = "ModelName")
    private String modelName;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "ProductImage")
    private String productImage;

    @Column(name = "UnitCost")
    private Integer unitCost;

    @Column(name = "Description")
    private String description;
}
