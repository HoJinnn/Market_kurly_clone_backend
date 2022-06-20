package com.marketkurly.clone.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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
    private String thumbnail;
    private String contentImageUrl;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;


    //==연관관계 메서드==//
    public void setReviews(Review review){
        reviews.add(review);
        review.setProduct(this);
    }

    @Builder
    public Product(String name, int price, String category, String subtitle, String salesUnit, String weight, String shippingCategory, String orgin, String packagingType, String allergic, String info, String thumbnail, String contentImageUrl) {
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
    }
}
