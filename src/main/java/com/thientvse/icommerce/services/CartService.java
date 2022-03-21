package com.thientvse.icommerce.services;

import com.thientvse.icommerce.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {

    Cart addProductToCart(Cart cart);

    void deleteProductFromCart(int id);

    List<Cart> getListProductFromCart();

    List<Cart> getListProductFromCartById(int id);

    void deleteAllProductInCart();


}
