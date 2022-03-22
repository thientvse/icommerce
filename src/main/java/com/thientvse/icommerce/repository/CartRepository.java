package com.thientvse.icommerce.repository;

import com.thientvse.icommerce.model.Cart;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUserId(int userId);
}
