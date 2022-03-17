package com.thientvse.icommerce.resource.exceptions;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Api(value = "Product resource")
@CrossOrigin
public class ProductResource {

    @GetMapping("/")
    @ApiOperation(value = "Demo api")
    public void sayHello(){
        System.out.println("Hello world");
    }

}
