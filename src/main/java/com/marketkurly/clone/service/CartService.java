package com.marketkurly.clone.service;

import com.marketkurly.clone.domain.Cart;
import com.marketkurly.clone.domain.Product;
import com.marketkurly.clone.domain.User;
import com.marketkurly.clone.dto.CartAddRequestDto;
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
    public List<CartResponseDto> getCart(Long userId) {
        List<Cart> carts = cartRepository.findAllByUser_Id(userId);

        return carts.stream()
                .map(c ->
                    CartResponseDto.builder()
                            .cartId(c.getId())
                            .productId(c.getProduct().getId())
                            .productName(c.getProduct().getName())
                            .productImage(c.getProduct().getThumbnail())
                            .price(c.getProduct().getPrice())
                            .subTitle(c.getProduct().getSubtitle())
                            .quantity(c.getQuantity())
                            .build())
                .collect(Collectors.toList());
    }

    //장바구니 담기
    @Transactional
    public void addCart(Long productId, CartAddRequestDto requestDto, User user) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        Cart getCart = cartRepository.findByProduct_IdAndUser_Id(productId, user.getId());

        if (getCart != null) {
            updateCart(getCart, requestDto.getQuantity(), requestDto.getTotalPrice());
        }else {
            Cart cart = Cart.builder()
                    .product(product)
                    .user(user)
                    .quantity(requestDto.getQuantity())
                    .totalPrice(requestDto.getTotalPrice())
                    .build();

            cartRepository.save(cart);
        }
    }

    //장바구니 품목 삭제
    @Transactional
    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    //장바구니 수량 변경
    public void updateCart(Cart cart, int quantity, int totalPrice) {
        cart.setQuantity(cart.getQuantity() + quantity);
        cart.setTotalPrice(cart.getTotalPrice() + totalPrice);
    }
}
