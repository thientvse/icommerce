package com.thientvse.icommerce.services;

import com.thientvse.icommerce.model.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {

    Cart addProductToCart(Cart cart);

    void deleteProductFromCart(int id);

//    List<Cart> getListProductFromCart();

    List<Cart> getListProductFromCartByUserId(int userId);

    void deleteAllProductInCart();
}
