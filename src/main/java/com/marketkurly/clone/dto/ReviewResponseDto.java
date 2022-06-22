package com.marketkurly.clone.dto;

import com.marketkurly.clone.domain.Review;
import com.marketkurly.clone.domain.TimeStamp;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class ReviewResponseDto {
    private Long productId;
    private Long id;
    private String commentTitle;
    private String commentDetail;
    private String imageFile;
    private LocalDateTime createdAt;
    private String name;

    public static ReviewResponseDto createResponseDto(Review review){
        ReviewResponseDto reviewResponseDto = new ReviewResponseDto();
        reviewResponseDto.setProductId(review.getProduct().getId());
        reviewResponseDto.setId(review.getId());
        reviewResponseDto.setCommentTitle(review.getCommentTitle());
        reviewResponseDto.setCommentDetail(review.getCommentDetail());
        reviewResponseDto.setImageFile(review.getImageFile());
        reviewResponseDto.setCreatedAt(review.getCreatedAt());
        reviewResponseDto.setName(review.getWriter());
        return reviewResponseDto;
    }

    public static ReviewResponseDto changeResponseDto(Review review){
        ReviewResponseDto reviewResponseDto = new ReviewResponseDto();
        reviewResponseDto.setProductId(review.getProduct().getId());
        reviewResponseDto.setId(review.getId());
        reviewResponseDto.setCommentTitle(review.getCommentTitle());
        reviewResponseDto.setCommentDetail(review.getCommentDetail());
        reviewResponseDto.setImageFile(review.getImageFile());
        reviewResponseDto.setCreatedAt(review.getModifiedAt());
        reviewResponseDto.setName(review.getWriter());
        return reviewResponseDto;
    }
}
