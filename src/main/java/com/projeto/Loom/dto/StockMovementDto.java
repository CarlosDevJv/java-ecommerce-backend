package com.projeto.Loom.dto;

import com.projeto.Loom.entities.Product;
import com.projeto.Loom.entities.StockMovement;
import com.projeto.Loom.entities.enums.MovementType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

}
