package com.marketkurly.clone.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ReviewRequestDto {
    private String commentTitle;
    private String commentDetail;
    private String imageFile;

    public ReviewRequestDto(String commentTitle, String commentDetail) {
        this.commentTitle = commentTitle;
        this.commentDetail = commentDetail;
    }
}
