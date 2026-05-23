package com.projeto.Loom.controller;

import com.projeto.Loom.dto.SupplierDto;
import com.projeto.Loom.entities.Supplier;
import com.projeto.Loom.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping(value = "/listSuppliers")
    public ResponseEntity<List<SupplierDto>> findAll(){
        return ResponseEntity.ok().body(supplierService.findAll());
    }

    @PostMapping(value = "/insertSuppliers")
    public ResponseEntity<HttpStatus> insertAll(@RequestBody List<Supplier> suppliers){
        supplierService.insertAll(suppliers);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
