package com.marketkurly.clone.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CartListDto {
    private String productName;
    private String subTitle;
    private String productImage;
    private int quantity;
    private int price;
}
