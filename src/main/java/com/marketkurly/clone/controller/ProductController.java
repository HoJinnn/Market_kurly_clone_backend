package com.marketkurly.clone.controller;

import com.marketkurly.clone.domain.Product;
import com.marketkurly.clone.dto.ProductRequestDto;
import com.marketkurly.clone.dto.ProductResponseDto;
import com.marketkurly.clone.repository.ProductRepository;
import com.marketkurly.clone.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @PostMapping("/api/product")
    public ResponseEntity<String> addProduct(@RequestBody ProductRequestDto requestDto) {
        Product product = Product.builder()
                .name(requestDto.getName())
                .thumbnail(requestDto.getThumbnail())
                .subtitle(requestDto.getSubtitle())
                .allergic(requestDto.getAllergic())
                .category(requestDto.getCategory())
                .contentImageUrl(requestDto.getContentImageUrl())
                .info(requestDto.getInfo())
                .price(requestDto.getPrice())
                .orgin(requestDto.getOrgin())
                .packagingType(requestDto.getPackagingType())
                .salesUnit(requestDto.getSalesUnit())
                .shippingCategory(requestDto.getShippingCategory())
                .weight(requestDto.getWeight())
                .build();
        productRepository.save(product);
        return ResponseEntity.ok("상품 등록 성공");
    }

    //게시물 전체 조회
    @GetMapping("/api/products")
    public List<ProductResponseDto> getproducts() {
        return productService.getProducts();
    }
}
