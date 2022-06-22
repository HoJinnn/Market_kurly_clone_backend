package com.marketkurly.clone.dto;

import com.marketkurly.clone.domain.Cart;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequestDto {
    private String address;
    private List<Cart> product;
    private int payment;
}
