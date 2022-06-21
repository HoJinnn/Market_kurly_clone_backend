package com.marketkurly.clone.service;

import com.marketkurly.clone.domain.Product;
import com.marketkurly.clone.dto.ProductResponseDto;
import com.marketkurly.clone.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponseDto> getProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(p ->
                    ProductResponseDto.builder()
                            .id(p.getId())
                            .name(p.getName())
                            .imageUrl(p.getThumbnail())
                            .price(p.getPrice())
                            .category(p.getCategory())
                            .build())
                .collect(Collectors.toList());
    }
}
