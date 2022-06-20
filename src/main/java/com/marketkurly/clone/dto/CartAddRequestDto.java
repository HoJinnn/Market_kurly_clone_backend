package com.marketkurly.clone.dto;


import lombok.Getter;

@Getter
public class CartAddRequestDto {
    private Long id;
    private int quantity;
    private int totalPrice;
}
