package com.marketkurly.clone.dto;

import com.marketkurly.clone.domain.Cart;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CartResponseDto {
    private String address;
    private List<CartListDto> cartListDto;

    public CartResponseDto(List<CartListDto> cartListDto) {
        this.cartListDto = cartListDto;
    }
}

