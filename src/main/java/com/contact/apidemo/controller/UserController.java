package com.contact.apidemo.controller;

import com.contact.apidemo.model.User;
import com.contact.apidemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    UserService userService;

    //http://localhost:8080/api/welcome
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to your contact app";
    }

    //http://localhost:8080/api/welcome
    @GetMapping("/CreateUser")
    public User createUser(@RequestBody User userObject){
        System.out.println("calling create user controller ====");
        return userService.createUser(userObject);

    }
}
