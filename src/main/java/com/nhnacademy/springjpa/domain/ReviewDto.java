package com.nhnacademy.springjpa.domain;

import com.nhnacademy.springjpa.entity.User;

public interface ReviewDto {
    Integer getReviewId();

    ProductDto getProduct();

    UserDto getUser();

}
