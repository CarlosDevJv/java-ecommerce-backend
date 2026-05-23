package com.projeto.Loom.repository;

import com.projeto.Loom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
