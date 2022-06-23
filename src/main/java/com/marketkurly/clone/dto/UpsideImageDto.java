package com.marketkurly.clone.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UpsideImageDto {
    private List<String> upsideImage = new ArrayList<>();

    public void settingImage(String imageLink){
        this.upsideImage.add(imageLink);
    }

}
