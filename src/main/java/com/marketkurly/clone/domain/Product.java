package com.marketkurly.clone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Product extends TimeStamp{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

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

    private String thumbnailUrl;

    private String contentImageUrl;
}
