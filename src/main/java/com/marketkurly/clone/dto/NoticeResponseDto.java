package com.marketkurly.clone.dto;

import lombok.Data;

import java.util.List;

@Data
public class NoticeResponseDto {
    private Long productId;

    private String productName;
    private String subtitle;

    private String salesUnit;
    private String weight;

    private String shippingCategory;
    private String orgin;

    private String packagingType;
    private String alergy;

    private String info;

    private String thumbnailUrl;
    private int productPrice;

    private String imageUrl;

    private String contentDetail;


    private List<ReviewResponseDto> reviews;

    public NoticeResponseDto(Long productId, String productName, String subtitle, String salesUnit, String weight, String shippingCategory, String orgin, String packagingType, String alergy, String info, String thumbnailUrl, int productPrice, String imageUrl, String contentDetail) {
        this.productId = productId;
        this.productName = productName;
        this.subtitle = subtitle;
        this.salesUnit = salesUnit;
        this.weight = weight;
        this.shippingCategory = shippingCategory;
        this.orgin = orgin;
        this.packagingType = packagingType;
        this.alergy = alergy;
        this.info = info;
        this.thumbnailUrl = thumbnailUrl;
        this.productPrice = productPrice;
        this.imageUrl = imageUrl;
        this.contentDetail = contentDetail;
    }
}
