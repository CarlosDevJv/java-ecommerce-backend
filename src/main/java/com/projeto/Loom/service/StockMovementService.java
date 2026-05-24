package com.projeto.Loom.service;

import com.projeto.Loom.dto.StockMovementDto;
import com.projeto.Loom.entities.Product;
import com.projeto.Loom.entities.StockMovement;
import com.projeto.Loom.repository.ProductRepository;
import com.projeto.Loom.repository.StockMovementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StockMovementService {
    @Autowired
    private StockMovementRepository stockMovementRepository;
    @Autowired
    private ProductRepository productRepository;


    public void create(StockMovementDto stockMovementDto) {
        Product product = productRepository.findById(stockMovementDto.getProductId()).orElseThrow(()-> new EntityNotFoundException("Produto não encontrado"));
        StockMovement stockMovement = new StockMovement();
        stockMovement.setMovementDate(stockMovementDto.getMovementDate());
        stockMovement.setMovementType(stockMovementDto.getMovementType());
        stockMovement.setReason(stockMovementDto.getReason());
        stockMovement.setQuantity(stockMovementDto.getQuantity());
        stockMovement.setCreatedBy(stockMovementDto.getCreatedBy());
        stockMovement.setProduct(product);

        stockMovementRepository.save(stockMovement);
    }
}
