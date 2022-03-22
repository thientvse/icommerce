package com.thientvse.icommerce.controller;

import com.thientvse.icommerce.dto.ShoppingCartDTO;
import com.thientvse.icommerce.model.ShoppingCart;
import com.thientvse.icommerce.services.ShoppingCartService;
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
    ShoppingCartService shoppingCartService;

    @PostMapping("/addProductToCart")
    public ResponseEntity<ShoppingCart> addProductToCart(
            @RequestBody ShoppingCartDTO cart){
        return new ResponseEntity<>(shoppingCartService.addProductToCart(cart), HttpStatus.OK);
    }


    @PostMapping("/updateProductInCart/{id}")
    public ResponseEntity<ShoppingCart> updateProductInCart(
            @RequestBody ShoppingCartDTO cart,@PathVariable Long id){
        return new ResponseEntity<>(shoppingCartService.updateProduct(cart, id), HttpStatus.OK);
    }


    @PostMapping("/getAllProductInShoppingCart")
    public ResponseEntity<List<ShoppingCart>> getAllProductInShoppingCart(){
        return new ResponseEntity<>(shoppingCartService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/deleteProductFromCart")
    public ResponseEntity<HttpStatus> deleteProductFromCart(
            @RequestParam long id){
        shoppingCartService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/getListProductFromCartByUserId/{userId}")
    public ResponseEntity<List<ShoppingCart>> getListProductFromCartByUserId(@PathVariable int userId){
        return new ResponseEntity<>(shoppingCartService.getListProductFromCartByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/deleteAllProductInCart")
    public ResponseEntity<HttpStatus> deleteAllProductInCart(){
        shoppingCartService.deleteAllProductInCart();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
