package com.thientvse.icommerce.services;

import com.thientvse.icommerce.dto.ShoppingCartDTO;
import com.thientvse.icommerce.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCart addProductToCart(ShoppingCartDTO cart);


//    List<Cart> getListProductFromCart();

    List<ShoppingCart> getListProductFromCartByUserId(long userId);

    void deleteAllProductInCart();

    List<ShoppingCart> findAll();

    ShoppingCart updateProduct(ShoppingCartDTO shoppingCartDTO, Long id);

    void deleteProduct(Long id);

    void clearShoppingCart(Object obj);

}
