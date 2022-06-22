package com.marketkurly.clone.dto;

import lombok.Getter;

@Getter
public class OrderRequestDto {
    private String address;
    private List<cart> product;
    private int payment;
}
