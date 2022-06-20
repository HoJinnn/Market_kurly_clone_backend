package com.marketkurly.clone.service;

import com.marketkurly.clone.domain.Review;
import com.marketkurly.clone.dto.NoticeCreateDto;
import com.marketkurly.clone.dto.NoticeResponseDto;
import com.marketkurly.clone.dto.ReviewResponseDto;
import com.marketkurly.clone.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeService {

    private final NoticeRepository noticeRepository;

    //게시글 상세 & 댓글 페이징 처리//
    public NoticeResponseDto findNotice(Long productId, int offset, int limit) {
        NoticeResponseDto notice = noticeRepository.findNotice(productId);
        List<Review> reviews = noticeRepository.findReviews(productId, offset, limit);
        List<ReviewResponseDto> reviewResponseDto = reviews.stream()
                        .map(ReviewResponseDto::createResponseDto)
                        .collect(Collectors.toList());
        notice.setReviews(reviewResponseDto);

        return notice;
    }


    @Transactional
    public void saveNotice(NoticeCreateDto noticeCreateDto) {
        noticeRepository.saveNotice(noticeCreateDto);
    }
}
