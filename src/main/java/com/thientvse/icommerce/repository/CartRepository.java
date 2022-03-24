package com.thientvse.icommerce.repository;

import com.thientvse.icommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

//    List<Cart> findAllByUserId(long userId);

    List<Cart> findCartByUserId(long userId);
}
