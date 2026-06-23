package com.projeto.Loom.service;

import com.projeto.Loom.dto.ProductDto;
import com.projeto.Loom.entities.Product;
import com.projeto.Loom.entities.StockMovement;
import com.projeto.Loom.entities.enums.MovementType;
import com.projeto.Loom.entities.enums.ProductStatus;
import com.projeto.Loom.repository.ProductRepository;
import com.projeto.Loom.repository.StockMovementRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StockMovementRepository stockMovementRepository;
    @Autowired
    private StockMovementService stockMovementService;

    public ProductDto findById(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
        return new ProductDto(product);
    }

    public List<ProductDto> findAll(){
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream()
                .map(ProductDto::new)
                .toList();
    }

    public void insert(ProductDto productDto){
        Product product = new Product(productDto);
        productRepository.save(product);
        stockMovementService.create(product);
    }

    public void withdraw(ProductDto productDto){
        if (productRepository.findById(productDto.getId()).isPresent()){
            Product product = productRepository.getReferenceById(productDto.getId());

            if (productDto.getQuantity() > product.getQuantity()){throw new IllegalArgumentException("Venda excede estoque");}
            int newQuantity = product.getQuantity() - productDto.getQuantity();

            product.setQuantity(productDto.getQuantity());
            stockMovementService.withdraw(product);
            productDto.setQuantity(newQuantity);
            product.setQuantity(newQuantity);

            update(productDto);
        }
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }


    public void update(ProductDto productDto){
        Product product = new Product(productDto);
        productRepository.findById(product.getId()).map(productUpdate -> {
            if (product.getName() != null && !product.getName().isBlank()) {
                productUpdate.setName(product.getName());
            }
            if (product.getPrice() != null && !product.getPrice().isNaN()) {
                productUpdate.setPrice(product.getPrice());
            }
            if (product.getSupplier() != null) {
                productUpdate.setSupplier(product.getSupplier());
            }
            if (product.getStatus() != null){
                productUpdate.setStatus(product.getStatus());
            }
            if (product.getQuantity() != null){
                productUpdate.setQuantity(product.getQuantity());
            }
            return productRepository.save(productUpdate);
        }).orElseThrow(() -> new IllegalArgumentException("Houve um erro ao tentar atualizar o produto"));
    }
}
