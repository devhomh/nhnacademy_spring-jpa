package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Reviews")
public class Reviews {
    @Id
    @Column(name = "review_id")
    private Integer reviewId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "comments")
    private String comments;
}
