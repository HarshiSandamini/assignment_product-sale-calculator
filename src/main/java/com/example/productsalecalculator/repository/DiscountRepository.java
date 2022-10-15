package com.example.productsalecalculator.repository;

import com.example.productsalecalculator.module.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
        }
