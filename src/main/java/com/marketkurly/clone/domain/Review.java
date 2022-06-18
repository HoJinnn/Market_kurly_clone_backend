package com.marketkurly.clone.domain;

import com.marketkurly.clone.dto.ReviewRequestDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends TimeStamp{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    private String commentTitle;
    private String commentDetail;
    private String imageFile;
    private String writer;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;*/

    //생성 메서드//
    public static Review createReview(ReviewRequestDto reviewRequestDto/*, String writer*/) {
        Review review = new Review();
        review.setCommentTitle(reviewRequestDto.getCommentTitle());
        review.setCommentDetail(reviewRequestDto.getCommentDetail());
        review.setImageFile(reviewRequestDto.getImageFile());
        /*review.setWriter(writer);*/
        return review;
    }


}
