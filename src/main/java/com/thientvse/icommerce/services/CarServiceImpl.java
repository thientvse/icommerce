package com.thientvse.icommerce.services;

import com.thientvse.icommerce.model.Cart;
import com.thientvse.icommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CartService {

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
    public List<Cart> getListProductFromCart() {
        return cartRepository.findAll();
    }

    @Override
    public List<Cart> getListProductFromCartById(int id) {
        return cartRepository.findAllByUserId(id);
    }

    @Override
    public void deleteAllProductInCart() {
        cartRepository.deleteAll();
    }
}


