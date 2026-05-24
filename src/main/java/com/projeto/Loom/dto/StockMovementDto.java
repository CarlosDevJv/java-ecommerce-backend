package com.projeto.Loom.dto;

import com.projeto.Loom.entities.Product;
import com.projeto.Loom.entities.StockMovement;
import com.projeto.Loom.entities.enums.MovementType;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StockMovementDto {
    private MovementType movementType;
    private String reason;
    private int quantity;
    private LocalDateTime movementDate;
    private String createdBy;
    private Long productId;

    public StockMovementDto(MovementType movementType, String reason, int quantity, LocalDateTime movementDate, String createdBy, Long productId) {
        this.movementType = movementType;
        this.reason = reason;
        this.quantity = quantity;
        this.movementDate = movementDate;
        this.createdBy = createdBy;
        this.productId = productId;
    }

    public StockMovementDto(StockMovement stockMovement){
        BeanUtils.copyProperties(stockMovement, this);
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
