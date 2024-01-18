package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.ProductDto;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CategoryRepositoryCustom {
    List<ProductDto> getProductByCategoryName(String categoryName);
}
