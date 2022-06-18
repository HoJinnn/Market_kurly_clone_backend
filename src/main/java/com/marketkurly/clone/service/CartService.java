package com.marketkurly.clone.service;

import com.marketkurly.clone.domain.Cart;
import com.marketkurly.clone.domain.Product;
import com.marketkurly.clone.dto.CartResponseDto;
import com.marketkurly.clone.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CartService {

    private final CartRepository cartRepository;
//    private final ProductRepository productRepository;

    public CartResponseDto getCart() {
        
    }
}
