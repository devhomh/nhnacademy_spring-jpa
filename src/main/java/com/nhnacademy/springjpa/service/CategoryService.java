package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.CategoryNameOnly;
import com.nhnacademy.springjpa.entity.Category;
import java.util.List;

public interface CategoryService {
    List<CategoryNameOnly> findAll();

    Category findByCategoryName(String categoryName);
}
