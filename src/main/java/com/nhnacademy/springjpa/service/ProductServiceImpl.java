package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.ProductDto;
import com.nhnacademy.springjpa.domain.ProductRequest;
import com.nhnacademy.springjpa.entity.Product;
import com.nhnacademy.springjpa.exception.ProductNotFoundException;
import com.nhnacademy.springjpa.repository.CategoryRepository;
import com.nhnacademy.springjpa.repository.ProductRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    @Override
    public Product getProduct(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Transactional
    @Override
    public Product registerProduct(ProductRequest registerRequest) {
        Product product = Product.builder(categoryRepository, registerRequest).build();

        return productRepository.save(product);
    }

    @Transactional
    @Override
    public void removeProduct(int productId) {
        productRepository.deleteById(productId);
    }

    @Transactional
    @Override
    public Page<ProductDto> getProductByCategoryName(String categoryName, Pageable pageable) {
        List<ProductDto> productList = productRepository.getProductByCategory_CategoryName(categoryName);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), productList.size());
        List<ProductDto> subList = productList.subList(start, end);

        return new PageImpl<>(subList, pageable, productList.size());
    }

    @Transactional
    @Override
    public List<Product> getProductHavingPriceAtLeast(int unitCost) {
        return productRepository.getProductHavingPriceAtLeast(unitCost);
    }

    @Transactional
    @Override
    public Page<ProductDto> findByModelNameContains(String modelName, Pageable pageable) {
        return productRepository.findByModelNameContains(modelName, pageable);
    }

    @Transactional
    @Override
    public Page<ProductDto> getAllBy(Pageable pageable) {
        return productRepository.getAllBy(pageable);
    }
}
