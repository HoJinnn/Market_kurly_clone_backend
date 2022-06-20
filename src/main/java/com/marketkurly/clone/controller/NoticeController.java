package com.marketkurly.clone.controller;


import com.marketkurly.clone.dto.NoticeCreateDto;
import com.marketkurly.clone.dto.NoticeResponseDto;
import com.marketkurly.clone.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @PostMapping("/create/notice")
    public String saveNotice(@RequestBody NoticeCreateDto noticeCreateDto){
        noticeService.saveNotice(noticeCreateDto);
        return "clear";
    }

    //상세 페이지 조회/
    @GetMapping("/api/products/{productId}")
    public NoticeResponseDto findNotice(@PathVariable("productId") Long productId){
        return noticeService.findNotice(productId,1,3);
    }
}
