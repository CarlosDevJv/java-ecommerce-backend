package com.projeto.Loom.service;

import com.projeto.Loom.dto.ProductDto;
import com.projeto.Loom.dto.StockMovementDto;
import com.projeto.Loom.entities.Product;
import com.projeto.Loom.entities.StockMovement;
import com.projeto.Loom.entities.enums.MovementType;
import com.projeto.Loom.repository.ProductRepository;
import com.projeto.Loom.repository.StockMovementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class StockMovementService {
    @Autowired
    private StockMovementRepository stockMovementRepository;
    @Autowired
    private ProductRepository productRepository;


    public void create(Product product) {
        StockMovement stockMovement = new StockMovement();
        stockMovement.setProduct(product);
        stockMovement.setMovementDate(LocalDateTime.now());
        stockMovement.setMovementType(MovementType.ENTRY);
        stockMovement.setReason("RENOVANDO ESTOQUE");
        stockMovement.setQuantity(product.getQuantity());
        stockMovement.setCreatedBy("TESTE SISTEMA");

        stockMovementRepository.save(stockMovement);
    }

    public void withdraw(Product product){
        StockMovement stockMovement = new StockMovement();
        if (productRepository.findById(product.getId()).isPresent()){
            stockMovement.setProduct(product);
            stockMovement.setMovementDate(LocalDateTime.now());
            stockMovement.setMovementType(MovementType.EXIT);
            stockMovement.setReason("VENDA DE PRODUTO");
            stockMovement.setQuantity(product.getQuantity());
            stockMovement.setCreatedBy("TESTE SISTEMA");


            stockMovementRepository.save(stockMovement);
        }
        else {
            throw new EntityNotFoundException("Produto não encontrado");
        }
    }
}
