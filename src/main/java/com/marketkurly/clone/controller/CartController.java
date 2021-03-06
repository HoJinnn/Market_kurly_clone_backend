package com.marketkurly.clone.controller;

import com.marketkurly.clone.dto.CartAddRequestDto;
import com.marketkurly.clone.dto.CartResponseDto;
import com.marketkurly.clone.security.UserDetailsImpl;
import com.marketkurly.clone.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CartController {

    private final CartService cartService;

    //장바구니 목록 호출 API
    @GetMapping("/api/cart")
    public List<CartResponseDto> getCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cartService.getCart(userDetails.getUser().getId());
    }

    //장바구니 담기 API
    @PostMapping("/api/cart/{productId}")
    public String addCart(@PathVariable Long productId, @RequestBody CartAddRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        cartService.addCart(productId, requestDto, userDetails.getUser());
        return "장바구니 담기 성공!";
    }

    //장바구니 품목 삭제 API
    @DeleteMapping("api/cart/{cartId}")
    public String deleteCart(@PathVariable Long cartId) {
        cartService.deleteCart(cartId);
        return "삭제 성공!";
    }
}
