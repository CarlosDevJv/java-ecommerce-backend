package com.projeto.Loom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.Loom.entities.Product;
import com.projeto.Loom.entities.Supplier;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank
    @NotNull
    private String name;
    @NotNull
    private Supplier supplier;
    private Double price;
    @NotNull
    @NotBlank
    private String size;
    @NotNull
    @NotBlank
    private String color;

    public ProductDto() {
    }
    public ProductDto(Product product){
        BeanUtils.copyProperties(product, this);
    }

}
