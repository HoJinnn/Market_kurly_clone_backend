package com.marketkurly.clone.controller;

import com.marketkurly.clone.dto.NoticeCreateDto;
import com.marketkurly.clone.dto.NoticeResponseDto;
import com.marketkurly.clone.dto.UpsideImageDto;
import com.marketkurly.clone.service.AwsS3Service;
import com.marketkurly.clone.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;
    private final AwsS3Service amazonS3;

    @PostMapping("/create/notice")
    public String saveNotice(@RequestBody NoticeCreateDto noticeCreateDto){
        noticeService.saveNotice(noticeCreateDto);
        return "clear";
    }

    //상세 페이지 조회/
    @GetMapping("/api/products/{productId}/index/{index}")
    public NoticeResponseDto findNotice(@PathVariable("productId") Long productId, @PathVariable("index") int index){
        return noticeService.findNotice(productId,(index-1)*7,((index-1)*7)+6);
    }

    //상단 이미지 조회//
    @GetMapping("/api/products/upsideimg")
    public UpsideImageDto findUpsideImage(){
        UpsideImageDto upsideImageDto = new UpsideImageDto();
        upsideImageDto.settingImage(amazonS3.getThumbnailPath("https://marketkurly-imageupload.s3.ap-northeast-2.amazonaws.com/contentImage/%EC%83%81%EB%8B%A8%EC%9D%B4%EB%AF%B8%EC%A7%801.png"));
        upsideImageDto.settingImage(amazonS3.getThumbnailPath("https://marketkurly-imageupload.s3.ap-northeast-2.amazonaws.com/contentImage/%EC%83%81%EB%8B%A8%EC%9D%B4%EB%AF%B8%EC%A7%802.png"));
        upsideImageDto.settingImage(amazonS3.getThumbnailPath("https://marketkurly-imageupload.s3.ap-northeast-2.amazonaws.com/contentImage/%EC%83%81%EB%8B%A8%EC%9D%B4%EB%AF%B8%EC%A7%803.png"));
        upsideImageDto.settingImage(amazonS3.getThumbnailPath("https://marketkurly-imageupload.s3.ap-northeast-2.amazonaws.com/contentImage/%EC%83%81%EB%8B%A8%EC%9D%B4%EB%AF%B8%EC%A7%804.png"));
        upsideImageDto.settingImage(amazonS3.getThumbnailPath("https://marketkurly-imageupload.s3.ap-northeast-2.amazonaws.com/contentImage/%EC%83%81%EB%8B%A8%EC%9D%B4%EB%AF%B8%EC%A7%805.png"));
        return upsideImageDto;
    }

}
