package com.projeto.Loom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.Loom.entities.Product;
import com.projeto.Loom.entities.Supplier;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

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



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
