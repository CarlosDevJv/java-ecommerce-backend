package com.projeto.Loom.service;

import com.projeto.Loom.dto.SupplierDto;
import com.projeto.Loom.entities.Supplier;
import com.projeto.Loom.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public void insert(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public void insertAll(List<Supplier> suppliers){
        supplierRepository.saveAll(suppliers);
    }

    public List<SupplierDto> findAll(){
        List<Supplier> allSupplier = supplierRepository.findAll();
        List<SupplierDto> all = allSupplier.stream()
                .map(SupplierDto::new).
                toList();
        return all;
    }
}
