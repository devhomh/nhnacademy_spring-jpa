package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @Column(name = "CategoryID")
    private Integer categoryId;

    @Column(name = "CategoryName")
    private String categoryName;
}
