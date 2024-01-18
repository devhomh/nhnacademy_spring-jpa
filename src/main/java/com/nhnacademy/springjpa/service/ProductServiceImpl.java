package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.ProductDto;
import com.nhnacademy.springjpa.domain.ProductRequest;
import com.nhnacademy.springjpa.entity.Product;
import com.nhnacademy.springjpa.exception.ProductNotFoundException;
import com.nhnacademy.springjpa.repository.CategoryRepository;
import com.nhnacademy.springjpa.repository.ProductRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
    public List<ProductDto> getProductByCategoryName(String categoryName) {
        return categoryRepository.getProductByCategoryName(categoryName);
    }

    @Transactional
    @Override
    public List<Product> getProductHavingPriceAtLeast(int unitCost) {
        return productRepository.getProductHavingPriceAtLeast(unitCost);
    }

    @Transactional
    @Override
    public List<ProductDto> findByModelNameLike(String modelName) {
        return productRepository.findByModelNameLike(modelName)
                .getContent();
    }

    @Transactional
    @Override
    public List<ProductDto> getAllBy(Pageable pageable) {
        Pageable fixedElementPage = PageRequest.ofSize(8);

        return productRepository.getAllBy(fixedElementPage).getContent();
    }
}
