package com.marketkurly.clone.dto;

import com.marketkurly.clone.domain.Cart;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CartResponseDto {
    private String productName;
    private String subTitle;
    private String productImage;
    private int quantity;
    private int price;

    @Builder
    public CartResponseDto(String productName, String subTitle, String productImage, int quantity, int price) {
        this.productName = productName;
        this.subTitle = subTitle;
        this.productImage = productImage;
        this.quantity = quantity;
        this.price = price;
    }
}

