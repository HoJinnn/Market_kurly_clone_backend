package com.marketkurly.clone.controller;

import com.marketkurly.clone.dto.CartRequestDto;
import com.marketkurly.clone.dto.CartResponseDto;
import com.marketkurly.clone.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartController {

    private final CartService cartService;

    @GetMapping("/api/cart")
    public CartResponseDto getCart() {
        return cartService.getCart();
    }

    //데이터 저장 테스트용 API
    @PostMapping("/api/cart")
    public void saveCart(@RequestBody CartRequestDto requestDto) {
        cartService.setData(requestDto);
    }
}
