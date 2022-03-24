package com.thientvse.icommerce.services;

import com.thientvse.icommerce.dto.ShoppingCartDTO;
import com.thientvse.icommerce.model.Cart;

import java.util.List;

public interface CartService {

    Cart addProductToCart(ShoppingCartDTO cart);

    void deleteProductFromCart(long id);

//    List<Cart> getListProductFromCart();

    List<Cart> getListProductFromCartByUserId(long userId);

    void deleteAllProductInCart();
}
