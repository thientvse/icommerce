package com.thientvse.icommerce.controller;

import com.thientvse.icommerce.model.Cart;
import com.thientvse.icommerce.repository.CartRepository;
import com.thientvse.icommerce.services.CartService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartController")
@Api(value = "Cart resource")
@CrossOrigin
public class CartController {

    @Autowired
    CartService cartService;


    @PostMapping("/addProductToCart")
    public ResponseEntity<Cart> addProductToCart(
            @RequestBody Cart cart){
        Cart cartCreated = cartService.addProductToCart(cart);
        return new ResponseEntity<>(cartCreated, HttpStatus.OK);
    }

    @PostMapping("/deleteProductFromCart")
    public ResponseEntity<HttpStatus> deleteProductFromCart(
            @RequestParam int id){
        cartService.deleteProductFromCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getListProductFromCart")
    public ResponseEntity<List<Cart>> getListProductFromCart(){
        return new ResponseEntity<>(cartService.getListProductFromCart(), HttpStatus.OK);
    }

    @GetMapping("/getListProductFromCartByUserId/{userId}")
    public ResponseEntity<List<Cart>> getListProductFromCartByUserId(@PathVariable int userId){
        return new ResponseEntity<>(cartService.getListProductFromCartById(userId), HttpStatus.OK);
    }

    @PostMapping("/deleteAllProductInCart")
    public ResponseEntity<HttpStatus> deleteAllProductInCart(){
        cartService.deleteAllProductInCart();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
