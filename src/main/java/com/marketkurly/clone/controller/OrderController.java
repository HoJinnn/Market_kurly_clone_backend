package com.marketkurly.clone.controller;

import com.marketkurly.clone.repository.OrderRepository;
import com.marketkurly.clone.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    @PostMapping("/api/order")
    public String registOrder(@RequestBody OrderRequestDto orderRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {


        return "등록 성공!";
    }
}
