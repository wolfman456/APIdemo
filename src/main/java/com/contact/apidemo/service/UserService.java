package com.contact.apidemo.service;


import com.contact.apidemo.model.User;

import java.util.List;

public interface UserService {
    public User createUser(User userObject);
    public List<User> getAllUsers();
    public User getSingleUser(Long userId);
}
