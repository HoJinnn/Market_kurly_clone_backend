package com.marketkurly.clone.repository;

import com.marketkurly.clone.domain.Product;
import com.marketkurly.clone.dto.ProductResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
