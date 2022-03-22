package com.thientvse.icommerce.services.impl;

import com.thientvse.icommerce.dto.ShoppingCartDTO;
import com.thientvse.icommerce.exceptions.ObjectNotFoundException;
import com.thientvse.icommerce.model.Product;
import com.thientvse.icommerce.model.ShoppingCart;
import com.thientvse.icommerce.repository.ShoppingCartRepository;
import com.thientvse.icommerce.repository.ProductRepository;
import com.thientvse.icommerce.repository.UserRepository;
import com.thientvse.icommerce.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {


    @Autowired
    public ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public UserRepository userRepository;


    @Override
    public ShoppingCart addProductToCart(ShoppingCartDTO shoppingCartDTO) {

        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = productRepository.findProductById(Math.toIntExact(shoppingCartDTO.getProductId()));
        shoppingCart.setProduct(product);
        shoppingCart.setStock(shoppingCartDTO.getStock());
        shoppingCart.setUser(userRepository.findById(1L).orElseThrow(ObjectNotFoundException::new));
        shoppingCart.setStatus(shoppingCartDTO.getStatus());
        shoppingCart.setAmount(String.valueOf(product.getUnitPrice() * shoppingCartDTO.getStock()));

        return shoppingCartRepository.save(shoppingCart);
    }





    @Override
    public List<ShoppingCart> getListProductFromCartByUserId(long userId) {
        return shoppingCartRepository.findAllByUserId(userId);
    }

    @Override
    public void deleteAllProductInCart() {
        shoppingCartRepository.deleteAll();
    }

    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
//        return shoppingCartRepository.findByStatus("NOT_PURCHASED");
    }

    @Override
    public ShoppingCart updateProduct(ShoppingCartDTO shoppingCartDTO, Long id) {
        ShoppingCart updateItem = shoppingCartRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        updateItem.setStock(shoppingCartDTO.getStock());
        updateItem.setAmount(String.valueOf(updateItem.getProduct().getUnitPrice() * shoppingCartDTO.getStock()));
        return shoppingCartRepository.save(updateItem);
    }

    @Override
    public void deleteProduct(Long id) {
        shoppingCartRepository.deleteById(id);
    }

    @Override
    public void clearShoppingCart(Object obj) {
        shoppingCartRepository.deleteAll();
    }
}
