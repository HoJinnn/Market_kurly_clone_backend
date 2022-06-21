package com.marketkurly.clone.controller;

import com.marketkurly.clone.domain.Review;
import com.marketkurly.clone.dto.ReviewRequestDto;
import com.marketkurly.clone.dto.ReviewResponseDto;
import com.marketkurly.clone.service.AwsS3Service;
import com.marketkurly.clone.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final AwsS3Service awsS3Service;

    //리뷰 조회용 컨트롤러 추후 삭제 예정//
    @GetMapping("/review")
    public List<Review> findReview(){
        return reviewService.findAll();
    }


    //리뷰 저장//
    @PostMapping("/api/products/{productId}/review")
    public ReviewResponseDto saveReview(@PathVariable("productId") Long productId, @RequestPart(value = "file") List<MultipartFile> multipartFile, @RequestPart(value = "key") ReviewRequestDto
            reviewRequestDto/*, @Authenticationprincipal UserDetailImpl userdetails*/){
        List<String> strings = awsS3Service.uploadFile(multipartFile);
        reviewRequestDto.setImageFile(strings.get(0));
        return reviewService.saveReview(productId, reviewRequestDto/*,userdetails.getUser()*/);
    }

    //리뷰 수정//
    @PatchMapping("/api/products/{productId}/review/{reviewId}")
    public ReviewResponseDto changeReview(@PathVariable("reviewId") Long reviewId, @RequestPart(value = "file") List<MultipartFile> multipartFile, @RequestPart(value = "key") ReviewRequestDto reviewRequestDto){
        List<String> strings = awsS3Service.uploadFile(multipartFile);
        reviewRequestDto.setImageFile(strings.get(0));
        return reviewService.changeReview(reviewId,reviewRequestDto);
    }

    //리뷰 삭제 ---> HttpStatus 적용 필요//
    @DeleteMapping("/api/products/{productId}/review/{reviewId}")
    public String deleteReview(@PathVariable("reviewId") Long reviewId){
        return reviewService.deleteReview(reviewId);
    }

    //
    /*@PostMapping("/upload")
    public String uploadFile(
            @RequestParam("category") String category,
            @RequestPart(value = "file") MultipartFile multipartFile) {
        return awsS3Service.uploadFileV1(category, multipartFile);
    }*/


    @PostMapping("/file")
    public String uploadFile(@RequestPart List<MultipartFile> multipartFile) {
        awsS3Service.uploadFile(multipartFile);
        return "성공";
    }

    @GetMapping("/file/find")
    public String findFile(){
       return awsS3Service.getThumbnailPath("4b027f72-c693-4057-992b-c84bbffaf5fc.jpg");
    }
}
