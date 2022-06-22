package com.marketkurly.clone.dto;

import lombok.Data;

@Data
public class NoticeCreateDto {
    private String name;
    private int price;
    private String category;
    private String subtitle;
    private String salesUnit;
    private String weight;
    private String shippingCategory;
    private String orgin;
    private String packagingType;
    private String allergic;
    private String info;
    private String thumbnail;
    private String contentImageUrl;

    private String contentDetail;

    public NoticeCreateDto(String name, int price, String category, String subtitle, String salesUnit, String weight, String shippingCategory, String orgin, String packagingType, String allergic, String info, String thumbnail, String contentImageUrl, String contentDetail) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.subtitle = subtitle;
        this.salesUnit = salesUnit;
        this.weight = weight;
        this.shippingCategory = shippingCategory;
        this.orgin = orgin;
        this.packagingType = packagingType;
        this.allergic = allergic;
        this.info = info;
        this.thumbnail = thumbnail;
        this.contentImageUrl = contentImageUrl;
        this.contentDetail = contentDetail;
    }
}
