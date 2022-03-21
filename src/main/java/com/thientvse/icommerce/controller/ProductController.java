package com.thientvse.icommerce.controller;


import com.thientvse.icommerce.model.Product;
import com.thientvse.icommerce.model.ProductRequest;
import com.thientvse.icommerce.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productController")
@Api(value = "Product resource")
@CrossOrigin
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("/")
    @ApiOperation(value = "Demo api")
    public ResponseEntity<String> sayHello(){
       return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<List<Product>> createProduct(
            @RequestBody List<Product> productList){
        List<Product> productsList = productService.createProduct(productList);
        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }

    @GetMapping("/searchProduct")
    public ResponseEntity<List<Product>> searchProduct(
            @RequestBody ProductRequest productRequest){
        List<Product> productsList = productService.searchProduct(productRequest);
        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }


    @GetMapping("/getProductDetail/{id}")
    public ResponseEntity<Product> getProductDetail(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(productService.getProductDetail(id), HttpStatus.OK);
    }

}
