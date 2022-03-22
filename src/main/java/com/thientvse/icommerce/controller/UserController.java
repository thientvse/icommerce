package com.thientvse.icommerce.controller;


import com.thientvse.icommerce.model.User;
import com.thientvse.icommerce.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/userController")
@Api(value = "Cart resource")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/initUser")
    public ResponseEntity<User> initUser(){

        userService.saveInitUser();

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
