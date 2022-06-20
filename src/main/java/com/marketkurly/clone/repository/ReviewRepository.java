package com.marketkurly.clone.repository;


import com.marketkurly.clone.domain.Review;
import com.marketkurly.clone.dto.ReviewRequestDto;
import com.marketkurly.clone.dto.ReviewResponseDto;
import com.marketkurly.clone.service.AwsS3Service;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {
    private final EntityManager em;
    private final AwsS3Service awsS3Service;
    //리뷰 저장//
    public Review saveReview(Review review/*,String writer*/){
        em.persist(review);
        return review;
    }

    //리뷰 수정//
    public Review changeReview(Long reviewId, ReviewRequestDto reviewRequestDto){
        Review review = em.find(Review.class, reviewId);
        review.setCommentTitle(reviewRequestDto.getCommentTitle());
        review.setCommentDetail(reviewRequestDto.getCommentDetail());
        awsS3Service.deleteFile(review.getImageFile());
        review.setImageFile(reviewRequestDto.getImageFile());

        return review;
    }

    //리뷰 삭제//
    public void deleteReview(Long reviewId) {
        Review review = em.find(Review.class, reviewId);
        awsS3Service.deleteFile(review.getImageFile());
        em.remove(review);
    }

    //리뷰 조회//
    public List<Review>  findAll() {
        List<Review> resultList = em.createQuery(" select r from Review r", Review.class).getResultList();
        return resultList;
    }
}
