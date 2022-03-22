package com.thientvse.icommerce.services.impl;

import com.thientvse.icommerce.model.Cart;
import com.thientvse.icommerce.repository.CartRepository;
import com.thientvse.icommerce.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {


    @Autowired
    public CartRepository cartRepository;


    @Override
    public Cart addProductToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteProductFromCart(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<Cart> getListProductFromCartByUserId(int userId) {
        return cartRepository.findAllByUserId(userId);
    }

    @Override
    public void deleteAllProductInCart() {
        cartRepository.deleteAll();
    }
}
