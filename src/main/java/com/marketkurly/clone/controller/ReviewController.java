package com.marketkurly.clone.controller;

import com.marketkurly.clone.dto.ReviewRequestDto;
import com.marketkurly.clone.dto.ReviewResponseDto;
import com.marketkurly.clone.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    //리뷰 저장//
    public ReviewResponseDto saveReview(ReviewRequestDto reviewRequestDto/*, @Authenticationprincipal UserDetailImpl userdetails*/){
        return reviewService.saveReview(reviewRequestDto/*,userdetails.getUser()*/);
    }
}
