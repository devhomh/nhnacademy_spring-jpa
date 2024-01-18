package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.CategoryNameOnly;
import com.nhnacademy.springjpa.entity.Category;
import com.nhnacademy.springjpa.repository.CategoryRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    @Override
    public List<CategoryNameOnly> findAll() {
        return categoryRepository.getAllBy();
    }

    @Transactional
    @Override
    public Category findByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
}
