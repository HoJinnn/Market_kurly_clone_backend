package com.marketkurly.clone.dto;

import com.marketkurly.clone.domain.Cart;
import lombok.Getter;

import java.util.List;

@Getter
public class CartRequestDto {
    private String address;
    private String productName;
    private String subTitle;
    private String productImage;
    private int quantity;
    private int price;
}
