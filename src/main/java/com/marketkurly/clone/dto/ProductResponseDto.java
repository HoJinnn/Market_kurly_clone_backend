package com.marketkurly.clone.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponseDto {
    private Long id;
    private String name;
    private String imageUrl;
    private int price;
    private String category;
}
