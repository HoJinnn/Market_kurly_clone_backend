package com.marketkurly.clone.repository;

import com.marketkurly.clone.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Long> {

//    @Query("select m from User m where m.usernaem = :username and m.age = :age")
//    List<User> findUser(@Param("username") String username, @Param("age") int age);
//
//    @Query("select new com.marketkurly.clone.dto.CartResponseDto(c.quantity, c.totalPrice) from Cart c join c.user u")
//    List<CartResponseDto> findCart();

    List<Cart> findAllByUser_Id(Long userId);
}
