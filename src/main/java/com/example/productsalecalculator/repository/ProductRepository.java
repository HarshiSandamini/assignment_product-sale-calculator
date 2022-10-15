package com.example.productsalecalculator.repository;

import com.example.productsalecalculator.module.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
