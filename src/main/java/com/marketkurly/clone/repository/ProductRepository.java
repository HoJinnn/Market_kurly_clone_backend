package com.marketkurly.clone.repository;

import com.marketkurly.clone.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
