package com.marketkurly.clone.service;

import com.marketkurly.clone.domain.Cart;
import com.marketkurly.clone.domain.Product;
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

    //DB에 임의의 값 저장해보기
    @Transactional
    public void setData(CartRequestDto requestDto) {
        Product product = Product.builder()
                .name(requestDto.getProductName())
                .subtitle(requestDto.getSubTitle())
                .thumbnail(requestDto.getProductImage())
                .build();
        productRepository.save(product);

        Cart cart = Cart.builder()
                .quantity(requestDto.getQuantity())
                .totalPrice(requestDto.getPrice())
                .product(product)
                .build();

        cartRepository.save(cart);
    }

    public CartResponseDto getCart() {
        List<Cart> carts = cartRepository.findAll();
        List<CartListDto> cartListDto = carts.stream()
                .map(c ->
                    CartListDto.builder()
                            .productName(c.getProduct().getName())
                            .productImage(c.getProduct().getThumbnail())
                            .price(c.getTotalPrice())
                            .subTitle(c.getProduct().getSubtitle())
                            .quantity(c.getQuantity())
                            .build())
                .collect(Collectors.toList());

        return new CartResponseDto(cartListDto);
    }
}
