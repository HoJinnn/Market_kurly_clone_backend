package com.marketkurly.clone.repository;

import com.marketkurly.clone.domain.Product;
import com.marketkurly.clone.domain.Review;
import com.marketkurly.clone.dto.NoticeCreateDto;
import com.marketkurly.clone.dto.NoticeResponseDto;
import com.marketkurly.clone.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeRepository {
    private final EntityManager em;
    public NoticeResponseDto findNotice(Long productId) {
        return em.createQuery(
                        " select new com.marketkurly.clone.dto.NoticeResponseDto(" +
                                "p.id,p.name,p.subtitle,p.salesUnit,p.weight,p.shippingCategory,p.orgin,p.packagingType,p.allergic,p.info,p.thumbnail,p.price,p.contentImageUrl,p.contentDetail)" +
                                " from Product p" +
                                " where p.id = :productId", NoticeResponseDto.class)
                .setParameter("productId", productId)
                .getSingleResult();
    }

    public List<Review> findReviews(Long productId, int offset, int limit) {
       return em.createQuery(
                " select r from Review r" +
                        " join fetch r.product p" +
                        " where p.id = :productId", Review.class)
                .setParameter("productId", productId)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    public void saveNotice(NoticeCreateDto noticeCreateDto) {
        Product product = new Product();
        product.setName(noticeCreateDto.getName());
        product.setPrice(noticeCreateDto.getPrice());
        product.setCategory(noticeCreateDto.getCategory());
        product.setSubtitle(noticeCreateDto.getSubtitle());
        product.setSalesUnit(noticeCreateDto.getSalesUnit());
        product.setWeight(noticeCreateDto.getWeight());
        product.setShippingCategory(noticeCreateDto.getShippingCategory());
        product.setOrgin(noticeCreateDto.getOrgin());
        product.setPackagingType(noticeCreateDto.getPackagingType());
        product.setAllergic(noticeCreateDto.getAllergic());
        product.setInfo(noticeCreateDto.getInfo());
        product.setThumbnail(noticeCreateDto.getThumbnail());
        product.setContentImageUrl(noticeCreateDto.getContentImageUrl());
        product.setContentDetail(noticeCreateDto.getContentDetail());
        em.persist(product);
    }
}
