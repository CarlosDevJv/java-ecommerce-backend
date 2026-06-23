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


    @PostMapping(value = "/insertProduct")
    public ResponseEntity<HttpStatus> insert(@RequestBody ProductDto productDto){
        productService.insert(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/replaceProduct")
    public ResponseEntity<HttpStatus> replace(@RequestBody ProductDto productDto){
        productService.update(productDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(value = "/withdraw")
    public ResponseEntity<HttpStatus> withdraw(@RequestBody ProductDto productDto){
        productService.withdraw(productDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
