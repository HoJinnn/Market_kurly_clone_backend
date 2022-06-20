package com.marketkurly.clone.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Cart extends TimeStamp{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    private int quantity;

    private int totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @Builder
    public Cart(int quantity, int totalPrice, Product product) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
    }
}
