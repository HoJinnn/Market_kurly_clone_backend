package com.marketkurly.clone.repository;


import com.marketkurly.clone.domain.Review;
import com.marketkurly.clone.dto.ReviewRequestDto;
import com.marketkurly.clone.dto.ReviewResponseDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {
    private EntityManager em;

    public ReviewResponseDto saveReview(ReviewRequestDto reviewRequestDto){
        Review review = Review.createReview(reviewRequestDto);
    }

}
