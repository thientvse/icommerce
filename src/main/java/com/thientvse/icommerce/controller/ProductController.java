package com.thientvse.icommerce.controller;


import com.thientvse.icommerce.model.Product;
import com.thientvse.icommerce.repository.specs.SearchCriteria;
import com.thientvse.icommerce.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productController")
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



    @GetMapping("/searchProduct")
    public ResponseEntity<List<Product>> searchProduct(
            @RequestBody List<SearchCriteria> searchCriteriaList){

        List<Product> productList = productService.searchProduct(searchCriteriaList);

       return new ResponseEntity<>(productList, HttpStatus.OK);
    }


    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(
            @RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }


    @GetMapping("/getDetailProduct/{id}")
    public ResponseEntity<Product> getDetailProduct(@PathVariable int id){
        return new ResponseEntity<>(productService.getDetailProduct(id), HttpStatus.OK);
    }






}
