package com.thientvse.icommerce.services.impl;

import com.thientvse.icommerce.dto.ShoppingCartDTO;
import com.thientvse.icommerce.model.Product;
import com.thientvse.icommerce.model.ShoppingCart;
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
    public ShoppingCart addProductToCart(ShoppingCartDTO shoppingCartDTO) {

        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = productRepository.findProductById(shoppingCartDTO.getProductId());
        shoppingCart.setProduct(product);
        shoppingCart.setStock(shoppingCartDTO.getStock());
        shoppingCart.setUser(userRepository.findUserByUserId(1L));
        shoppingCart.setStatus(shoppingCartDTO.getStatus());
        shoppingCart.setAmount(String.valueOf(product.getProductPrice() * shoppingCartDTO.getStock()));

        return cartRepository.save(shoppingCart);
    }



    @Override
    public void deleteProductFromCart(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<ShoppingCart> getListProductFromCartByUserId(int userId) {
        return cartRepository.findAllByUserId(userId);
    }

    @Override
    public void deleteAllProductInCart() {
        cartRepository.deleteAll();
    }
}
