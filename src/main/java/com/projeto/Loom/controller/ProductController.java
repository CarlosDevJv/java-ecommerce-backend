package com.projeto.Loom.controller;

import com.projeto.Loom.dto.ProductDto;
import com.projeto.Loom.entities.Product;
import com.projeto.Loom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/listProducts")
    public ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.ok().body(productService.findAll());
    }

    @PostMapping(value = "/insertProducts")
    public ResponseEntity<HttpStatus> insertALl(@RequestBody List<Product> product){
        productService.insertAll(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/insertProduct")
    public ResponseEntity<HttpStatus> insert(@RequestBody Product product){
        productService.insert(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/replaceProduct")
    public ResponseEntity<HttpStatus> replace(@RequestBody ProductDto product){
        productService.update(2L, product);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
