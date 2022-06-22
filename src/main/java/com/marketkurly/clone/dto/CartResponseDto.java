package com.marketkurly.clone.dto;

import com.marketkurly.clone.domain.Cart;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CartResponseDto {

    private Long cartId;
    private Long productId;
    private String productName;
    private String subTitle;
    private String productImage;
    private int quantity;
    private int price;

    @Builder
    public CartResponseDto(Long cartId, Long productId, String productName, String subTitle, String productImage, int quantity, int price) {
        this.cartId = cartId;
        this.productId = productId;
        this.productName = productName;
        this.subTitle = subTitle;
        this.productImage = productImage;
        this.quantity = quantity;
        this.price = price;
    }
}

