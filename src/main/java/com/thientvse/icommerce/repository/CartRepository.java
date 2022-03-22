package com.thientvse.icommerce.repository;

import com.thientvse.icommerce.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<ShoppingCart, Integer> {

    List<ShoppingCart> findAllByUserId(int userId);
}
