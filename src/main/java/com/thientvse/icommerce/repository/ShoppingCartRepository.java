package com.thientvse.icommerce.repository;

import com.thientvse.icommerce.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    List<ShoppingCart> findByStatus(String status);
    List<ShoppingCart> findAllByUserId(long userId);


}
