package com.marketkurly.clone.controller;

import com.marketkurly.clone.domain.Review;
import com.marketkurly.clone.dto.ReviewRequestDto;
import com.marketkurly.clone.dto.ReviewResponseDto;
import com.marketkurly.clone.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    //리뷰 조회용 컨트롤러 추후 삭제 예정//
    @GetMapping("/review")
    public List<Review> findReview(){
        return reviewService.findAll();
    }


    //리뷰 저장//
    @PostMapping("/api/products/{productId}/review")
    public ReviewResponseDto saveReview(@RequestBody ReviewRequestDto reviewRequestDto/*, @Authenticationprincipal UserDetailImpl userdetails*/){
        return reviewService.saveReview(reviewRequestDto/*,userdetails.getUser()*/);
    }

    //리뷰 수정//
    @PatchMapping("/api/products/{productId}/review/{reviewId}")
    public ReviewResponseDto changeReview(@PathVariable("reviewId") Long reviewId, @RequestBody ReviewRequestDto reviewRequestDto){
        return reviewService.changeReview(reviewId,reviewRequestDto);
    }

    //리뷰 삭제 ---> HttpStatus 적용 필요//
    @DeleteMapping("/api/products/{productId}/review/{reviewId}")
    public String deleteReview(@PathVariable("reviewId") Long reviewId){
        return reviewService.deleteReview(reviewId);
    }
}
