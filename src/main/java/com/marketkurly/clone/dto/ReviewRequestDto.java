package com.marketkurly.clone.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewRequestDto {
    private String commentTitle;
    private String commentDetail;
    private String imageFile;
}
