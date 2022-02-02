package com.contact.apidemo.controller;

import com.contact.apidemo.model.User;
import com.contact.apidemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.util.List;

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

    //http://localhost:8080/api/CreateUser
    @PostMapping("/CreateUser")
    public User createUser(@RequestBody User userObject){
        System.out.println("calling create user controller ====");
        return userService.createUser(userObject);

    }

    //http://localhost:8080/api/getAllUsers
    @GetMapping("getAllUsers")
    public List<User> getAllUsers(){
        System.out.println("Calling get all user controller");
        return userService.getAllUsers();
    }

    //http://localhost:8080/api/{userID}
    @GetMapping("/getSingleUser/{userId}")
    public User getSingleUser(@PathVariable Long userId){
        return userService.getSingleUser(userId);
    }

    //http://localhost:8080/api/{userID}
    @PutMapping("/getSingleUser/{userId}")
    public User updateUser(@PathVariable (value = "userId") Long userId, @RequestBody User user){
        return userService.updateUser(userId, user);
    }

    //http://localhost:8080/api/{userID}
    @DeleteMapping("/getSingleUser/{userId}")
    public String deleteUser(@PathVariable(value = "userId") Long userId){
        return userService.deleteUser(userId);
    }


}
