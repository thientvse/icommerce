package com.thientvse.icommerce.services;

import com.thientvse.icommerce.dto.ShoppingCartDTO;
import com.thientvse.icommerce.model.ShoppingCart;

import java.util.List;

public interface CartService {

    ShoppingCart addProductToCart(ShoppingCartDTO cart);

    void deleteProductFromCart(int id);

//    List<Cart> getListProductFromCart();

    List<ShoppingCart> getListProductFromCartByUserId(int userId);

    void deleteAllProductInCart();
}
