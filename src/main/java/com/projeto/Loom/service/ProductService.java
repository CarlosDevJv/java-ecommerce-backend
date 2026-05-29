package com.projeto.Loom.service;

import com.projeto.Loom.dto.ProductDto;
import com.projeto.Loom.entities.Product;
import com.projeto.Loom.entities.StockMovement;
import com.projeto.Loom.entities.enums.MovementType;
import com.projeto.Loom.repository.ProductRepository;
import com.projeto.Loom.repository.StockMovementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StockMovementRepository stockMovementRepository;

    public ProductDto findById(Long id){
        Product product = productRepository.findById(id).get();
        return new ProductDto(product);
    }

    public List<ProductDto> findAll(){
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream()
                .map(ProductDto::new)
                .toList();
    }

    public void insert(Product product){
        StockMovement stockMovement = new StockMovement();
        stockMovement.setProduct(product);
        stockMovement.setQuantity(1);
        stockMovement.setCreatedBy("Sistema_Automatico");
        stockMovement.setMovementType(MovementType.ENTRY);
        stockMovement.setReason("Renovando Estoque");
        stockMovement.setMovementDate(LocalDateTime.now());
        stockMovement.setProduct(product);
        productRepository.save(product);
        stockMovementRepository.save(stockMovement);

    }

    public void insertAll(List<Product> productList){
        productRepository.saveAll(productList);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public Product update(Long id, ProductDto productDto){
        return productRepository.findById(id).map(productUpdate -> {
            if(productDto.getName() != null && !productDto.getName().isBlank()){
            productUpdate.setName(productDto.getName());
        }
        if (productDto.getColor() != null && !productDto.getColor().isBlank()) {
            productUpdate.setColor(productDto.getColor());
        }
        if (productDto.getSize() != null && !productDto.getSize().isBlank()) {
            productUpdate.setSize(productDto.getSize());
        }
        if (productDto.getPrice() != null && !productDto.getPrice().isNaN()) {
            productUpdate.setPrice(productDto.getPrice());
        }
        if (productDto.getSupplier() != null) {
            productUpdate.setSupplier(productDto.getSupplier());
        }
        return productRepository.save(productUpdate);}).orElseThrow(() -> new IllegalArgumentException("Houve um erro ao tentar atualizar o produto"));
    }

}
