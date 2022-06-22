package com.marketkurly.clone.repository;

import com.marketkurly.clone.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
