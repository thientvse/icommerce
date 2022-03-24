package com.thientvse.icommerce.services.impl;

import com.thientvse.icommerce.dto.ShoppingCartDTO;
import com.thientvse.icommerce.model.Product;
import com.thientvse.icommerce.model.Cart;
import com.thientvse.icommerce.repository.CartRepository;
import com.thientvse.icommerce.repository.ProductRepository;
import com.thientvse.icommerce.repository.UserRepository;
import com.thientvse.icommerce.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {


    @Autowired
    public CartRepository cartRepository;

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public UserRepository userRepository;


    @Override
    public Cart addProductToCart(ShoppingCartDTO shoppingCartDTO) {

        Cart cart = new Cart();

        Product product = productRepository.findProductById(shoppingCartDTO.getProductId());
        cart.setProduct(product);
        cart.setStock(shoppingCartDTO.getStock());
        cart.setUserId(userRepository.findUserByUserId(1L).getUserId());
        cart.setStatus(shoppingCartDTO.getStatus());
        cart.setPrice(product.getProductPrice() * shoppingCartDTO.getStock());

        return cartRepository.save(cart);
    }



    @Override
    public void deleteProductFromCart(long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<Cart> getListProductFromCartByUserId(long userId) {
        return cartRepository.findCartByUserId(userId);
    }

    @Override
    public void deleteAllProductInCart() {
        cartRepository.deleteAll();
    }
}
