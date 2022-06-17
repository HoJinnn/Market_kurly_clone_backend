package com.marketkurly.clone.service;

import com.marketkurly.clone.domain.Review;
import com.marketkurly.clone.dto.ReviewRequestDto;
import com.marketkurly.clone.dto.ReviewResponseDto;
import com.marketkurly.clone.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    //리뷰 저장//
    @Transactional
    public ReviewResponseDto saveReview(ReviewRequestDto reviewRequestDto /*,String writer*/){
        Review review = reviewRepository.saveReview(reviewRequestDto);
        return ReviewResponseDto.createResponseDto(review);
    }
}
