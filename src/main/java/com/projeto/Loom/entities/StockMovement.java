package com.projeto.Loom.entities;

import com.projeto.Loom.dto.StockMovementDto;
import com.projeto.Loom.entities.enums.MovementType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Entity
public class StockMovement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    private MovementType movementType;
    @NotBlank
    @NotNull
    private String reason;
    @NotNull
    private int quantity;
    @NotNull
    private LocalDateTime movementDate;
    @NotBlank
    @NotNull
    private String createdBy;
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    public StockMovement(Long id, MovementType movementType, String reason, int quantity, LocalDateTime movementDate, String createdBy, Product product) {
        this.id = id;
        this.movementType = movementType;
        this.reason = reason;
        this.quantity = quantity;
        this.movementDate = movementDate;
        this.createdBy = createdBy;
        this.product = product;
    }
    public StockMovement(){}

    public StockMovement(StockMovementDto stockMovementDto){
        BeanUtils.copyProperties(stockMovementDto, this);
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(LocalDateTime movementDate) {
        this.movementDate = movementDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
