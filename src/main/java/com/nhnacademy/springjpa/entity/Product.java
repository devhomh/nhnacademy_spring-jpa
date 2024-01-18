package com.nhnacademy.springjpa.entity;

import com.nhnacademy.springjpa.domain.ProductRequest;
import com.nhnacademy.springjpa.repository.CategoryRepository;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "ProductBuilder")
@Getter
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "model_number")
    private String modelNumber;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unitcost")
    private Long unitCost;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product")
    private List<ShoppingCartProduct> shoppingCartProducts;

    public static ProductBuilder builder(CategoryRepository categoryRepository, ProductRequest productRequest){
        Category category = categoryRepository.findByCategoryName(productRequest.getCategoryName());
        return ProductBuilder()
                .category(category)
                .modelNumber(productRequest.getModelNumber())
                .modelName(productRequest.getModelName())
                .quantity(productRequest.getQuantity())
                .unitCost(productRequest.getUnitCost())
                .description(productRequest.getDescription());
    }
}
