package com.thientvse.icommerce.controller;

import com.thientvse.icommerce.dto.ShoppingCartDTO;
import com.thientvse.icommerce.model.Cart;
import com.thientvse.icommerce.services.CartService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/cartController")
@Api(value = "Cart resource")
@CrossOrigin
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addProductToCart")
    public ResponseEntity<Cart> addProductToCart(
            @RequestBody ShoppingCartDTO cart){
        Cart cartCreated = cartService.addProductToCart(cart);
        return new ResponseEntity<>(cartCreated, HttpStatus.OK);
    }

    @PostMapping("/deleteProductFromCart")
    public ResponseEntity<HttpStatus> deleteProductFromCart(
            @RequestParam long id){
        cartService.deleteProductFromCart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/getListProductFromCartByUserId/{userId}")
    public ResponseEntity<List<Cart>> getListProductFromCartByUserId(@PathVariable long userId){
        return new ResponseEntity<>(cartService.getListProductFromCartByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/deleteAllProductInCart")
    public ResponseEntity<HttpStatus> deleteAllProductInCart(){
        cartService.deleteAllProductInCart();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
