package com.projeto.Loom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.Loom.dto.ProductDto;
import com.projeto.Loom.entities.enums.ProductStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
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
    @NotNull
    private Double price;
    @NotNull
    private Integer quantity;
    @NotNull
    private ProductStatus status;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<StockMovement> stockMovements;

    public Product() {
    }
    public Product(Long id, String name, Supplier supplier, Double price, Integer quantity, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public Product(Long id, String name, Supplier supplier, Double price, List<StockMovement> stockMovements, Integer quantity, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
        this.stockMovements = stockMovements;
        this.quantity = quantity;
        this.status = status;
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
