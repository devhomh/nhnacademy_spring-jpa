package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.ProductDto;
import com.nhnacademy.springjpa.entity.Category;
import com.nhnacademy.springjpa.entity.QCategory;
import com.nhnacademy.springjpa.entity.QProduct;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CategoryRepositoryImpl extends QuerydslRepositorySupport implements CategoryRepositoryCustom {
    public CategoryRepositoryImpl() {
        super(Category.class);
    }

    @Override
    public List<ProductDto> getProductByCategoryName(String categoryName) {
        QCategory category = QCategory.category;
        QProduct product = QProduct.product;

        return from(category)
                .innerJoin(product)
                .where(category.categoryName.eq(categoryName))
                .select(Projections.bean(ProductDto.class))
                .fetch();
    }
}
