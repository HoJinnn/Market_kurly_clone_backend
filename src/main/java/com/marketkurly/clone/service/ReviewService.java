package com.marketkurly.clone.service;

import com.marketkurly.clone.domain.Review;
import com.marketkurly.clone.dto.ReviewRequestDto;
import com.marketkurly.clone.dto.ReviewResponseDto;
import com.marketkurly.clone.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    //리뷰 조회 추후 삭제 예정//
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    //리뷰 저장//
    @Transactional
    public ReviewResponseDto saveReview(ReviewRequestDto reviewRequestDto /*,String writer*/){
        Review review = reviewRepository.saveReview(reviewRequestDto);
        return ReviewResponseDto.createResponseDto(review);
    }

    //리뷰 수정//
    @Transactional
    public ReviewResponseDto changeReview(Long reviewId, ReviewRequestDto reviewRequestDto){
        Review review = reviewRepository.changeReview(reviewId, reviewRequestDto);
        return ReviewResponseDto.createResponseDto(review);
    }

    //리뷰 삭제//
    @Transactional
    public String deleteReview(Long reviewId) {
        reviewRepository.deleteReview(reviewId);
        return "clear";
    }


}
