package com.nhnacademy.springjpa.domain;

import lombok.Value;

@Value
public class ProductRequest {
    String categoryName;

    String modelNumber;

    String modelName;

    Integer quantity;

    Long unitCost;

    String description;
}
