package com.projeto.Loom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.Loom.dto.ProductDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotBlank
    @NotNull
    private String name;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    private Double price;
    @NotNull
    @NotBlank
    private String size;
    @NotNull
    @NotBlank
    private String color;
    private Integer quantity;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<StockMovement> stockMovements;

    public Product() {
    }
    public Product(Long id, String name, Supplier supplier, Double price, String size, String color) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
        this.size = size;
        this.color = color;
    }

    public Product(Long id, String name, Supplier supplier, Double price, String size, String color, List<StockMovement> stockMovements, Integer quantity) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
        this.size = size;
        this.color = color;
        this.stockMovements = stockMovements;
    }

    public Product(ProductDto productDto){
        BeanUtils.copyProperties(productDto, this);
    }

    @JsonIgnore
    public List<StockMovement> getStockMovements() {
        return stockMovements;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
