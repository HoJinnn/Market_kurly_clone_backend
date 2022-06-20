package com.marketkurly.clone.service;

import com.marketkurly.clone.domain.Cart;
import com.marketkurly.clone.domain.Product;
import com.marketkurly.clone.dto.CartAddRequestDto;
import com.marketkurly.clone.dto.CartListDto;
import com.marketkurly.clone.dto.CartRequestDto;
import com.marketkurly.clone.dto.CartResponseDto;
import com.marketkurly.clone.repository.CartRepository;
import com.marketkurly.clone.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    //장바구니 목록 호출
    public CartResponseDto getCart() {
        List<Cart> carts = cartRepository.findAll();
        List<CartListDto> cartListDto = carts.stream()
                .map(c ->
                    CartListDto.builder()
                            .productName(c.getProduct().getName())
                            .productImage(c.getProduct().getThumbnail())
                            .price(c.getProduct().getPrice())
                            .subTitle(c.getProduct().getSubtitle())
                            .quantity(c.getQuantity())
                            .build())
                .collect(Collectors.toList());

        return new CartResponseDto(cartListDto);
    }

    //장바구니 담기
    @Transactional
    public void addCart(Long productId, CartAddRequestDto requestDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        Cart cart = Cart.builder()
                .product(product)
                .quantity(requestDto.getQuantity())
                .totalPrice(requestDto.getTotalPrice())
                .build();

        cartRepository.save(cart);
    }

    //장바구니 품목 삭제
    @Transactional
    public void deleteCart(Long productId) {
        cartRepository.deleteByProduct_Id(productId);
    }
}
