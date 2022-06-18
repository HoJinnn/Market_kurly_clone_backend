package com.marketkurly.clone.dto;

import com.marketkurly.clone.domain.Review;
import com.marketkurly.clone.domain.TimeStamp;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewResponseDto {
    private Long id;
    private String commentTitle;
    private String commentDetail;
    private String imageFile;
    private LocalDateTime createdAt;
    /*private String name;*/

    /*createTime 설정 필요*/
    /*--------------------*/

    public static ReviewResponseDto createResponseDto(Review review){
        ReviewResponseDto reviewResponseDto = new ReviewResponseDto();
        reviewResponseDto.setId(review.getId());
        reviewResponseDto.setCommentTitle(review.getCommentTitle());
        reviewResponseDto.setCommentDetail(review.getCommentDetail());
        reviewResponseDto.setImageFile(review.getImageFile());
        reviewResponseDto.setCreatedAt(review.getCreatedAt());
        /*reviewResponseDto.setName(review.getWriter());*/
        return reviewResponseDto;
    }

    public static ReviewResponseDto changeResponseDto(Review review){
        ReviewResponseDto reviewResponseDto = new ReviewResponseDto();
        reviewResponseDto.setId(review.getId());
        reviewResponseDto.setCommentTitle(review.getCommentTitle());
        reviewResponseDto.setCommentDetail(review.getCommentDetail());
        reviewResponseDto.setImageFile(review.getImageFile());
        reviewResponseDto.setCreatedAt(review.getModifiedAt());
        /*reviewResponseDto.setName(review.getWriter());*/
        return reviewResponseDto;
    }
}
