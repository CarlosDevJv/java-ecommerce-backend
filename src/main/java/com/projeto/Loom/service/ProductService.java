package com.projeto.Loom.service;

import com.projeto.Loom.dto.ProductDto;
import com.projeto.Loom.entities.Product;
import com.projeto.Loom.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

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
        productRepository.save(product);
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
