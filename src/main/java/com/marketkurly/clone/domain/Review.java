package com.marketkurly.clone.domain;

import com.marketkurly.clone.dto.ReviewRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    private String commentTitle;
    private String commentDetail;
    private String imageFile;
    private String writer;


    //생성 메서드//
    public static Review createReview(ReviewRequestDto reviewRequestDto, String writer) {
        Review review = new Review();
        review.setCommentTitle(reviewRequestDto.getCommentTitle());
        review.setCommentDetail(reviewRequestDto.getCommentDetail());
        review.setImageFile(reviewRequestDto.getImageFile());
    }

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;*/
}
