package com.marketkurly.clone.controller;

import com.marketkurly.clone.dto.CartResponseDto;
import com.marketkurly.clone.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartController {

    private final CartService cartService;

    @GetMapping("/api/cart")
    public CartResponseDto getCart() {
        return cartService.getCart();
    }
}
