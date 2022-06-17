package com.marketkurly.clone.dto;

import com.marketkurly.clone.domain.Review;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewResponseDto {
    private Long id;
    private String commentTitle;
    private String commentDetail;
    private String imageFile;

    /*private String name;*/

    /*createTime 설정 필요*/
    /*--------------------*/

    public static ReviewResponseDto createResponseDto(Review review){
        ReviewResponseDto reviewResponseDto = new ReviewResponseDto();
        reviewResponseDto.setId(reviewResponseDto.getId());
        reviewResponseDto.setCommentTitle(review.getCommentTitle());
        reviewResponseDto.setCommentDetail(review.getCommentDetail());
        reviewResponseDto.setImageFile(review.getImageFile());
        /*reviewResponseDto.setName(review.getWriter());*/
        return reviewResponseDto;
    }
}
