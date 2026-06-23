package com.projeto.Loom.dto;

import com.projeto.Loom.entities.Product;
import com.projeto.Loom.entities.Supplier;
import com.projeto.Loom.entities.enums.ProductStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Setter
@Component
public class ProductDto {
    private Long id;
    private String name;
    private Supplier supplier;
    private Double price;
    private Integer quantity;
    private ProductStatus status;

    public ProductDto() {
    }
    public ProductDto(Product product){
        BeanUtils.copyProperties(product, this);
    }
}
