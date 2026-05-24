package com.projeto.Loom.controller;

import com.projeto.Loom.dto.StockMovementDto;
import com.projeto.Loom.service.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stockMovement")
public class StockMovementController {
    @Autowired
    private StockMovementService stockMovementService;

    @PostMapping(value = "/create")
    public ResponseEntity<HttpStatus> create(StockMovementDto stockMovementDto){
        stockMovementService.create(stockMovementDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
